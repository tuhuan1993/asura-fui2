package com.asura.fui.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyConfigManager {

	private static final Logger logger = LoggerFactory.getLogger(PropertyConfigManager.class);

	private static Properties settings = new Properties();

	private static Set<String> keys = new HashSet<>();

	private PropertyConfigManager() {
		super();
	}

	public static void loadSettingResource(String filePath) {
		InputStream in = PropertyConfigManager.class.getResourceAsStream(filePath);
		try {
			settings.load(in);
			in.close();
		} catch (IOException e) {
			logger.error("load property files failed ", e);
		}
		for (Object key : settings.keySet()) {
			keys.add((String) key);
		}
	}

	public static String getSettingProperty(String key) {
		return settings.getProperty(key);
	}

	public static Set<String> getPropertyKeys() {
		return keys;
	}

	public static String getKeyByValue(String value) {
		Set<Map.Entry<Object, Object>> entries = settings.entrySet();
		for (Map.Entry<Object, Object> entry : entries) {
			if (((String) entry.getValue()).equals(value)) {
				return (String) entry.getKey();
			}
		}
		return value;
	}
}
