package com.asura.fui.page;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.asura.fui.config.FuiConverter;
import com.asura.fui.config.IM;
import com.asura.fui.config.PropertyConfigManager;
import com.asura.fui.page.view.FuiPage;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.script.IUIScript;
import com.asura.tools.util.StringUtil;
import com.asura.tools.util.math.NumberUtil;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class PageFactory {

	private static final Logger logger = LoggerFactory.getLogger(PageFactory.class);

	private Cache<String, FuiPage> cachePage;

	private Cache<String, IUIData> cacheData;

	private Cache<String, IUIScript> cacheScript;

	private PageFactory() {
		long timeout = NumberUtil.getLong(PropertyConfigManager.getSettingProperty(IM.PROPERTY_PAGE_TIMEOUT));
		cachePage = CacheBuilder.newBuilder().maximumSize(1000).expireAfterWrite(timeout, TimeUnit.SECONDS).build();
		cacheData = CacheBuilder.newBuilder().maximumSize(1000).expireAfterWrite(timeout, TimeUnit.SECONDS).build();
		cacheScript = CacheBuilder.newBuilder().maximumSize(1000).expireAfterWrite(timeout, TimeUnit.SECONDS).build();

	}

	public static PageFactory instance() {
		return SinletonHolder.instance;
	}

	private static class SinletonHolder {
		private static final PageFactory instance = new PageFactory();
	}

	public void init(String pageDirectory, int timeOut) {
		PageLoader.instance().init(pageDirectory, timeOut);
	}

	public FuiPage getPageByXml(String xml) {
		return FuiConverter.getPage(xml);
	}

	public IUIData getDataByXml(String xml) {
		return FuiConverter.getData(xml);
	}

	public IUIScript getScriptByXml(String xml) {
		return FuiConverter.getScript(xml);
	}

	public FuiPage getPage(final String suffix) {
		try {
			return cachePage.get(suffix, new Callable<FuiPage>() {
				@Override
				public FuiPage call() throws Exception {
					String content = PageLoader.instance().getContentByName(suffix);
					if (StringUtil.isNullOrEmpty(content)) {
						return null;
					}
					try {
						return FuiConverter.getPage(content);
					} catch (Exception e) {
						logger.error("Exception in get page method ", e);
						return null;
					}
				}
			});
		} catch (Exception e) {
			logger.error("Exception in get page method ", e);
			return null;
		}

	}

	public IUIData getData(final String suffix) {
		try {
			return cacheData.get(suffix, new Callable<IUIData>() {
				@Override
				public IUIData call() throws Exception {
					String content = PageLoader.instance().getContentByName(suffix);
					if (StringUtil.isNullOrEmpty(content)) {
						return null;
					}
					try {
						return FuiConverter.getData(content);
					} catch (Exception e) {
						return null;
					}
				}
			});
		} catch (Exception e) {
			logger.error("Exception in get page method ", e);
			return null;
		}

	}

	public IUIScript getScript(final String suffix) {
		try {
			return cacheScript.get(suffix, new Callable<IUIScript>() {
				@Override
				public IUIScript call() throws Exception {
					String content = PageLoader.instance().getContentByName(suffix);
					if (StringUtil.isNullOrEmpty(content)) {
						return null;
					}
					try {
						return FuiConverter.getScript(content);
					} catch (Exception e) {
						return null;
					}
				}
			});
		} catch (Exception e) {
			logger.error("Exception in get page method ", e);
			return null;
		}

	}
}
