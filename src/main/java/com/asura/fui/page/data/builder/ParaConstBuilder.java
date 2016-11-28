package com.asura.fui.page.data.builder;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.service.dispatch.FuiUrl;

public class ParaConstBuilder extends AbstractParaBuilder {
	private Object value;

	public FrontData build(FuiUrl url, FrontData data) {
		FrontData d = new FrontData();

		d.addField(this.key, this.value);

		return d;
	}

	public Object getValue() {
		return this.value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
