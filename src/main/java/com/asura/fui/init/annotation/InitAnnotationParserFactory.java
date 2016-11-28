package com.asura.fui.init.annotation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.ConstructorUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.asura.fui.init.InitListener;
import com.asura.tools.annotation.parser.AnnotationParserFactory;

public class InitAnnotationParserFactory implements AnnotationParserFactory {

	private static final Logger logger = LoggerFactory.getLogger(InitAnnotationParserFactory.class);

	private List<InitListener> listeners = new ArrayList<>();

	@Override
	public void init(String[] packages, Set<Class<?>> classes) throws Exception {
		logger.info("begin to init " + StringUtils.join(packages, ","));
		for (Class<?> cls : classes) {
			Init initAnnotation = cls.getAnnotation(Init.class);
			InitListener initListener = (InitListener) ConstructorUtils.invokeConstructor(cls, null);
			initListener.setPriority(initAnnotation.priority());
			listeners.add(initListener);
		}

		Collections.sort(listeners, new Comparator<InitListener>() {

			@Override
			public int compare(InitListener l1, InitListener l2) {
				return l2.getPriority() - l1.getPriority();
			}
		});

		logger.info("end to init " + StringUtils.join(packages, ","));
	}

	public List<InitListener> getInitListeners() {
		return this.listeners;
	}

}
