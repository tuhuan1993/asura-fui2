package com.asura.fui.page.data.builder;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.service.dispatch.FuiUrl;

public class ParaDecorateBuilder extends AbstractParaBuilder {
	private IParaBuilder buidler;
	private FrontData data;

	public IParaBuilder getBuidler() {
		return this.buidler;
	}

	public void setBuidler(IParaBuilder buidler) {
		this.buidler = buidler;
	}

	public FrontData getData(FuiUrl url, FrontData data) {
		if (this.data == null) {
			this.data = this.buidler.build(url, data);
		}
		return this.data;
	}

	public FrontData build(FuiUrl url, FrontData data) {
		if (this.data == null) {
			this.data = this.buidler.build(url, data);
		}
		return this.data;
	}
}