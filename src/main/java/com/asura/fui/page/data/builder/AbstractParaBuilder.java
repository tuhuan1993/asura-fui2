package com.asura.fui.page.data.builder;

public abstract class AbstractParaBuilder implements IParaBuilder {
	protected String key;

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
