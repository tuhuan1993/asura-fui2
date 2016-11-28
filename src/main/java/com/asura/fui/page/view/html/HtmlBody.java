package com.asura.fui.page.view.html;

import com.asura.fui.page.data.FrontData;

public class HtmlBody extends AbstractHtmlElement {
	public HtmlBody() {
	}

	public HtmlBody(FrontData paras) {
		super(paras);
	}

	public String getTag() {
		return "body";
	}
}
