package com.asura.fui.page;

import com.asura.fui.config.FuiConverter;
import com.asura.fui.page.view.FuiPage;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.script.IUIScript;
import com.asura.tools.util.StringUtil;

public class PageFactory {

	private PageFactory() {

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

	public FuiPage getPage(String suffix) {
		String content = PageLoader.instance().getContentByName(suffix);
		if (StringUtil.isNullOrEmpty(content)) {
			return null;
		}
		try {
			return FuiConverter.getPage(content);
		} catch (Exception e) {
			return null;
		}
	}

	public IUIData getData(String suffix) {
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

	public IUIScript getScript(String suffix) {
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
}
