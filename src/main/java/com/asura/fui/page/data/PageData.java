package com.asura.fui.page.data;

import java.util.ArrayList;
import java.util.List;

import com.asura.fui.page.data.builder.IParaBuilder;
import com.asura.fui.page.data.builder.ParaConstBuilder;
import com.asura.fui.page.data.builder.ParaSimpleBuilder;
import com.asura.fui.service.dispatch.FuiUrl;
import com.asura.tools.util.StringUtil;

public class PageData {

	private List<IParaBuilder> builders;

	public PageData() {
		this.builders = new ArrayList<>();
	}

	public void addPageData(IParaBuilder builder) {
		this.builders.add(builder);
	}

	public void addConstant(String field, Object value) {
		ParaConstBuilder c = new ParaConstBuilder();
		c.setKey(field);
		if ((value instanceof String) && (StringUtil.isNullOrEmpty((String) value))) {
			value = "";
		}

		c.setValue(value);
		addPageData(c);
	}

	public void addParaField(String key, String field) {
		ParaSimpleBuilder builder = new ParaSimpleBuilder();
		builder.setKey(key);
		builder.setField(field);
		addPageData(builder);
	}

	public List<IParaBuilder> getBuilders() {
		return this.builders;
	}

	public void setBuilders(List<IParaBuilder> builders) {
		this.builders = builders;
	}

	public FrontData getPageData(FuiUrl url, FrontData paras) {
		FrontData d = new FrontData();
		for (IParaBuilder builder : this.builders) {
			d.merge(builder.build(url, paras));
		}

		return d;
	}

}
