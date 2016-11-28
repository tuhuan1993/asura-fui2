package com.asura.fui.page.data.builder;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.service.dispatch.FuiUrl;

public interface IParaBuilder {
	public FrontData build(FuiUrl url, FrontData data);
}
