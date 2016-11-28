package com.asura.fui.listener;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.asura.fui.config.IM;
import com.asura.fui.config.PropertyConfigManager;
import com.asura.fui.init.InitListener;
import com.asura.fui.init.annotation.Init;
import com.asura.fui.init.annotation.InitAnnotationParserFactory;
import com.asura.tools.annotation.parser.AnnotationParserFactoryBuilder;
import com.asura.tools.util.StringUtil;

public class StartUpListener implements ServletContextListener {

	private static Logger logger = LoggerFactory.getLogger(StartUpListener.class);

	private InitAnnotationParserFactory factory;

	private List<InitListener> listeners;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("server is started.");

		initializePropertyConfig(sce);

		logger.info("property config manager has been initialized.");

		constructInitListeners();

		logger.info("init listeners have been constructed.");

		for (InitListener listener : listeners) {
			logger.info("begin to init " + listener.getClass().getSimpleName());
			try {
				listener.init(sce);
			} catch (Exception e) {
				logger.error("init failed " + listener.getClass().getSimpleName(), e);
				throw new RuntimeException("init failed " + listener.getClass().getSimpleName());
			}

			logger.info("end to init " + listener.getClass().getSimpleName());
		}

		logger.info("server initialized successfully.");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		for (InitListener listener : listeners) {
			logger.info("begin to destroy " + listener.getClass().getSimpleName());
			listener.destroy(sce);
			logger.info("end to destroy " + listener.getClass().getSimpleName());
		}
		logger.info("server stopped.");

	}

	private void initializePropertyConfig(ServletContextEvent sce) {
		String fuiConfFile = sce.getServletContext().getInitParameter(IM.CONTEXT_FUI_CONF_FILE);

		logger.info("load fui config file " + fuiConfFile);

		PropertyConfigManager.loadSettingResource(fuiConfFile);
	}

	private void constructInitListeners() {
		String packageStr = PropertyConfigManager.getSettingProperty(IM.PROPERTY_SCAN_PACKS_INIT_LISTNERS);
		if (StringUtil.isNullOrEmpty(packageStr)) {
			packageStr = "com.asura.fui.init.imp";
		}
		String[] packages = StringUtil.getStringsFromString(packageStr, ",");
		Set<String> packsSet = new HashSet<>();
		for (String pack : packages) {
			packsSet.add(pack);
		}
		packsSet.add("com.asura.fui.init.imp");
		logger.info("init scan packages are "
				+ StringUtil.getStringFromStrings(Arrays.asList(packsSet.toArray(new String[] {})), ","));
		try {
			factory = new AnnotationParserFactoryBuilder.Builder<InitAnnotationParserFactory>(
					packsSet.toArray(new String[] {})).build(Init.class, new InitAnnotationParserFactory());
		} catch (Exception e) {
			logger.error("initialize init annotation factory failed", e);
			throw new RuntimeException("initialize init annotation factory failed");
		}

		listeners = factory.getInitListeners();
	}

}
