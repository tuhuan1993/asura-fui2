package com.asura.fui.data.annotation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.ConstructorUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.asura.fui.data.IDataProvider;
import com.asura.tools.annotation.parser.AnnotationParserFactory;

public class DataProviderAnnotationParserFactory implements AnnotationParserFactory {

	private static final Logger logger = LoggerFactory.getLogger(DataProviderAnnotationParserFactory.class);

	private Map<String, Map<String, IDataProvider>> catKeyProviderMap = new HashMap<>();

	@Override
	public void init(String[] packages, Set<Class<?>> classes) throws Exception {
		logger.info("begin to init " + StringUtils.join(packages, ","));
		for (Class<?> cls : classes) {
			DataProvider dataProviderAnnotation = cls.getAnnotation(DataProvider.class);
			IDataProvider provider = (IDataProvider) ConstructorUtils.invokeConstructor(cls, null);
			String cat = dataProviderAnnotation.category();
			String key = dataProviderAnnotation.key();
			provider.setCategory(cat);
			provider.setKey(key);
			;
			provider.setParameters(dataProviderAnnotation.parameters());

			if (!catKeyProviderMap.containsKey(cat)) {
				catKeyProviderMap.put(cat, new HashMap<String, IDataProvider>());
			}

			catKeyProviderMap.get(cat).put(key, provider);
		}

		logger.info("end to init " + StringUtils.join(packages, ","));
	}

	public IDataProvider getDataProvider(String cat, String key) {
		return catKeyProviderMap.get(cat) != null ? catKeyProviderMap.get(cat).get(key) : null;
	}

}
