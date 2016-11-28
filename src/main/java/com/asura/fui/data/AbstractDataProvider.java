package com.asura.fui.data;

public abstract class AbstractDataProvider implements IDataProvider {

	private String category;

	private String key;

	private String[] parameters;

	@Override
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String getCategory() {
		return this.category;
	}

	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public void setParameters(String[] parameters) {
		this.parameters = parameters;
	}

	@Override
	public String[] getParameters() {
		return this.parameters;
	}

	@Override
	public IDataProvider clone() {
		IDataProvider idp = null;
		try {
			idp = (IDataProvider) super.clone();
		} catch (Exception e) {
			idp = null;
		}
		return idp;
	}

}
