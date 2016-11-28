package com.asura.fui.post.annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.ConstructorUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.asura.fui.data.annotation.DataProviderAnnotationParserFactory;
import com.asura.fui.post.IPostHandler;
import com.asura.tools.annotation.parser.AnnotationParserFactory;

public class PostHandlerAnnotationParserFactory implements AnnotationParserFactory {

	private static final Logger logger = LoggerFactory.getLogger(DataProviderAnnotationParserFactory.class);

	private List<IPostHandler> postHandlers = new ArrayList<>();

	@Override
	public void init(String[] packages, Set<Class<?>> classes) throws Exception {
		logger.info("begin to init " + StringUtils.join(packages, ","));
		for (Class<?> cls : classes) {
			IPostHandler provider = (IPostHandler) ConstructorUtils.invokeConstructor(cls, null);
			postHandlers.add(provider);
		}

		logger.info("end to init " + StringUtils.join(packages, ","));
	}

	public List<IPostHandler> getPostHandlers() {
		return postHandlers;
	}

}
