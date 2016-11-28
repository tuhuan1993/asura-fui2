package com.asura.fui.page;

import com.asura.fui.page.handler.PageHandler;
import com.asura.fui.page.handler.annotation.PH;
import com.asura.fui.page.handler.annotation.PHAnnotationParserFactory;
import com.asura.tools.annotation.parser.AnnotationParserFactoryBuilder;

public class HandlerFactory {

	// private static final Logger
	// logger=LoggerFactory.getLogger(HandlerFactory.class);

	private PHAnnotationParserFactory factory;

	private HandlerFactory() {

	}

	public static HandlerFactory instance() {
		return SinletonHolder.instance;
	}

	private static class SinletonHolder {
		private static final HandlerFactory instance = new HandlerFactory();
	}

	public void init(String[] packages) throws Exception {
		factory = new AnnotationParserFactoryBuilder.Builder<PHAnnotationParserFactory>(packages).build(PH.class,
				new PHAnnotationParserFactory());
	}

	public PageHandler getHandler(String name) {
		return factory.getHandler(name) != null ? factory.getHandler(name).clone() : null;
	}
}
