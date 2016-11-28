package com.asura.fui.page.view.html;

import com.asura.fui.page.data.FrontData;

public class HtmlDiv extends AbstractHtmlElement {
	public HtmlDiv() {
	}

	public HtmlDiv(FrontData paras) {
		super(paras);
	}

	public String getTag() {
		return "div";
	}
}
