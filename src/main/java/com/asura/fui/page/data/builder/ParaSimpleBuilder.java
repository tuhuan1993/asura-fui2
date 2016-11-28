package com.asura.fui.page.data.builder;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.service.dispatch.FuiUrl;

public class ParaSimpleBuilder extends AbstractParaBuilder {
	private String field;

	public FrontData build(FuiUrl url, FrontData data) {
		FrontData d = new FrontData();

		d.addField(this.key, data.getValue(this.field));

		return d;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}
}
