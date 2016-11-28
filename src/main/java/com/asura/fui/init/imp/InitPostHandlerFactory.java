package com.asura.fui.init.imp;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.asura.fui.config.IM;
import com.asura.fui.config.PropertyConfigManager;
import com.asura.fui.init.AbstractInit;
import com.asura.fui.init.annotation.Init;
import com.asura.fui.post.PostHandlerFactory;
import com.asura.tools.util.StringUtil;

@Init
public class InitPostHandlerFactory extends AbstractInit {

	private static Logger logger = LoggerFactory.getLogger(InitPostHandlerFactory.class);

	@Override
	public void init(ServletContextEvent context) throws Exception {
		String packageStr = PropertyConfigManager.getSettingProperty(IM.PROPERTY_SCAN_PACKS_POST_HANDLERS);
		if (!StringUtil.isNullOrEmpty(packageStr)) {
			String[] packages = StringUtil.getStringsFromString(packageStr, ",");
			logger.info("scan packages are " + StringUtil.getStringFromStrings(packages, ","));
			PostHandlerFactory.instance().init(packages);
		}
	}

	@Override
	public void destroy(ServletContextEvent context) {

	}

}
