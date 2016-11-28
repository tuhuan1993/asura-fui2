package com.asura.fui.data;

import com.asura.fui.data.annotation.DataProvider;
import com.asura.fui.data.annotation.DataProviderAnnotationParserFactory;
import com.asura.tools.annotation.parser.AnnotationParserFactoryBuilder;

public class DataProviderFactory {

	// private static final Logger
	// logger=LoggerFactory.getLogger(HandlerFactory.class);

	private DataProviderAnnotationParserFactory factory;

	private DataProviderFactory() {

	}

	public static DataProviderFactory instance() {
		return SinletonHolder.instance;
	}

	private static class SinletonHolder {
		private static final DataProviderFactory instance = new DataProviderFactory();
	}

	public void init(String[] packages) throws Exception {
		factory = new AnnotationParserFactoryBuilder.Builder<DataProviderAnnotationParserFactory>(packages)
				.build(DataProvider.class, new DataProviderAnnotationParserFactory());
	}

	public IDataProvider getProvider(String cat, String key) {
		return factory.getDataProvider(cat, key) != null ? factory.getDataProvider(cat, key) : null;
	}
}
