package com.asura.fui.page.data.builder;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.service.dispatch.FuiUrl;

public class ParaAddBuilder extends AbstractParaBuilder {
	private String value;

	public FrontData build(FuiUrl url, FrontData data) {
		FrontData d = new FrontData();

		d.addField(this.key, this.value);

		return d;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}