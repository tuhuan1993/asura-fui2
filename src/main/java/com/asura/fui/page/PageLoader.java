package com.asura.fui.page;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.asura.tools.util.FileUtil;
import com.asura.tools.util.StringUtil;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class PageLoader {

	private Cache<String, String> cache = null;

	private String page_directory = "/pages";

	private PageLoader() {

	}

	public static PageLoader instance() {
		return SinletonHolder.instance;
	}

	private static class SinletonHolder {
		private static final PageLoader instance = new PageLoader();
	}

	public void init(String pageDirectory, int timeout) {
		this.page_directory = pageDirectory;
		cache = CacheBuilder.newBuilder().maximumSize(1000).expireAfterWrite(timeout, TimeUnit.SECONDS).build();
		try {
			File directory = new File(page_directory);
			if (directory.exists() && directory.isDirectory()) {
				cache.cleanUp();
				System.out.println("begin to load pages from directory " + directory.getAbsolutePath());
				for (File page : directory.listFiles()) {
					if (page.getName().endsWith(".xml")) {
						String key = page.getName();
						String content = FileUtil.getFileContent(page.getPath(), "utf8");
						System.out.println("Loading page key: " + key);
						cache.put(key, content);
					}
				}
				System.out.println("end to load pages");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getContentByName(final String key) {
		String value = "";
		try {
			value = cache.get(key, new Callable<String>() {
				@Override
				public String call() throws IOException {
					System.out.println("Cache timeout for the key: " + key);
					System.out.println("Loading from page directory: " + page_directory);
					String suffix = "";
					if (key.startsWith("/")) {
						suffix = key;
					} else {
						suffix = "/" + key;
					}
					String page_url = page_directory + suffix;
					File page = new File(page_url);
					String content = "";
					if (page.exists()) {
						content = FileUtil.getFileContent(page.getPath(), "utf8");
					} else {
						URL source_page_url = this.getClass().getClassLoader().getResource("pages" + suffix);
						if (source_page_url != null) {
							content = StringUtil
									.getStringFromStrings(
											FileUtil.getContentByLine(source_page_url.openStream(), "UTF8"), "\n")
									.trim();
						}
					}
					return content;
				}
			});
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return value;
	}

}
