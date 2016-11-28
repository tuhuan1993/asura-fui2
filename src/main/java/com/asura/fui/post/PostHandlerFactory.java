package com.asura.fui.post;

import java.util.List;

import com.asura.fui.post.annotation.PostHandler;
import com.asura.fui.post.annotation.PostHandlerAnnotationParserFactory;
import com.asura.tools.annotation.parser.AnnotationParserFactoryBuilder;

public class PostHandlerFactory {

	// private static final Logger
	// logger=LoggerFactory.getLogger(HandlerFactory.class);

	private PostHandlerAnnotationParserFactory factory;

	private PostHandlerFactory() {

	}

	public static PostHandlerFactory instance() {
		return SinletonHolder.instance;
	}

	private static class SinletonHolder {
		private static final PostHandlerFactory instance = new PostHandlerFactory();
	}

	public void init(String[] packages) throws Exception {
		factory = new AnnotationParserFactoryBuilder.Builder<PostHandlerAnnotationParserFactory>(packages)
				.build(PostHandler.class, new PostHandlerAnnotationParserFactory());
	}

	public List<IPostHandler> getPostHandlers() {
		return factory.getPostHandlers();
	}
}
