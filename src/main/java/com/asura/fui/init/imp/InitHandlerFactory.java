package com.asura.fui.init.imp;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.asura.fui.config.IM;
import com.asura.fui.config.PropertyConfigManager;
import com.asura.fui.init.AbstractInit;
import com.asura.fui.init.annotation.Init;
import com.asura.fui.page.HandlerFactory;
import com.asura.tools.util.StringUtil;

@Init
public class InitHandlerFactory extends AbstractInit {

	private static Logger logger = LoggerFactory.getLogger(InitHandlerFactory.class);

	@Override
	public void init(ServletContextEvent context) throws Exception {
		String packageStr = PropertyConfigManager.getSettingProperty(IM.PROPERTY_SCAN_PACKS_PAGE_HANDLERS);
		if (!StringUtil.isNullOrEmpty(packageStr)) {
			String[] packages = StringUtil.getStringsFromString(packageStr, ",");
			logger.info("scan packages are " + StringUtil.getStringFromStrings(packages, ","));
			HandlerFactory.instance().init(packages);
		}
	}

	@Override
	public void destroy(ServletContextEvent context) {

	}

}
