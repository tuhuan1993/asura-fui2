package com.asura.fui.page.view.html;

import com.asura.fui.page.data.FrontData;

public class HtmlLi extends AbstractHtmlElement {
	public HtmlLi() {
	}

	public HtmlLi(FrontData paras) {
		super(paras);
	}

	public String getTag() {
		return "li";
	}
}
