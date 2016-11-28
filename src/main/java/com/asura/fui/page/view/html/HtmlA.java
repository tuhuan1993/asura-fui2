package com.asura.fui.page.view.html;

import com.asura.fui.page.data.FrontData;

public class HtmlA extends AbstractHtmlElement {
	public HtmlA() {
	}

	public HtmlA(FrontData paras) {
		super(paras);
	}

	public String getTag() {
		return "a";
	}

	public void setUrl(String url) {
		addAttr("href", url);
	}
}
