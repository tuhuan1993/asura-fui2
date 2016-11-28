package com.asura.fui.page.handler.annotation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.ConstructorUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.asura.fui.page.handler.PageHandler;
import com.asura.tools.annotation.parser.AnnotationParserFactory;
import com.asura.tools.util.StringUtil;

public class PHAnnotationParserFactory implements AnnotationParserFactory {

	private static final Logger logger = LoggerFactory.getLogger(PHAnnotationParserFactory.class);

	private Map<String, PageHandler> pageHandlerMap = new HashMap<>();

	@Override
	public void init(String[] packages, Set<Class<?>> classes) throws Exception {
		logger.info("begin to init " + StringUtils.join(packages, ","));
		for (Class<?> cls : classes) {
			PH pageHandler = cls.getAnnotation(PH.class);
			PageHandler handler = (PageHandler) ConstructorUtils.invokeConstructor(cls, null);
			if (!StringUtil.isNullOrEmpty(pageHandler.alias())) {
				if (pageHandlerMap.containsKey(pageHandler.alias())) {
					throw new Exception("there is duplicate page handler name exists " + pageHandler.alias());
				}
				pageHandlerMap.put(pageHandler.alias(), handler);
			}

			String simpleName = cls.getPackage().getName() + "." + cls.getSimpleName();

			if (pageHandlerMap.containsKey(simpleName)) {
				throw new Exception("there is duplicate page handler name exists " + simpleName);
			}
			pageHandlerMap.put(simpleName, handler);
		}

		logger.info("end to init " + StringUtils.join(packages, ","));
	}

	public PageHandler getHandler(String name) {
		return pageHandlerMap.get(name);
	}

}
