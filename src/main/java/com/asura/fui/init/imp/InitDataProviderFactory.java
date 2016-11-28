package com.asura.fui.init.imp;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.asura.fui.config.IM;
import com.asura.fui.config.PropertyConfigManager;
import com.asura.fui.data.DataProviderFactory;
import com.asura.fui.init.AbstractInit;
import com.asura.fui.init.annotation.Init;
import com.asura.tools.util.StringUtil;

@Init
public class InitDataProviderFactory extends AbstractInit {

	private static Logger logger = LoggerFactory.getLogger(InitDataProviderFactory.class);

	@Override
	public void init(ServletContextEvent context) throws Exception {
		String packageStr = PropertyConfigManager.getSettingProperty(IM.PROPERTY_SCAN_PACKS_DATA_PROVIDERS);
		if (!StringUtil.isNullOrEmpty(packageStr)) {
			String[] packages = StringUtil.getStringsFromString(packageStr, ",");
			logger.info("scan packages are " + StringUtil.getStringFromStrings(packages, ","));
			DataProviderFactory.instance().init(packages);
		}
	}

	@Override
	public void destroy(ServletContextEvent context) {

	}

}
