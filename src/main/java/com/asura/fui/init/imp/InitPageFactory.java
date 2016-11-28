package com.asura.fui.init.imp;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.asura.fui.config.IM;
import com.asura.fui.config.PropertyConfigManager;
import com.asura.fui.init.AbstractInit;
import com.asura.fui.init.annotation.Init;
import com.asura.fui.page.PageFactory;
import com.asura.tools.util.math.NumberUtil;

@Init
public class InitPageFactory extends AbstractInit {

	private static Logger logger = LoggerFactory.getLogger(InitPageFactory.class);

	@Override
	public void init(ServletContextEvent context) throws Exception {
		String pageDirectory = PropertyConfigManager.getSettingProperty(IM.PROPERTY_PAGE_DIRECTORY);
		String timeOutStr = PropertyConfigManager.getSettingProperty(IM.PROPERTY_PAGE_TIMEOUT);
		logger.info("page directory is " + pageDirectory);
		PageFactory.instance().init(pageDirectory, NumberUtil.getInt(timeOutStr));

	}

	@Override
	public void destroy(ServletContextEvent context) {

	}

}
