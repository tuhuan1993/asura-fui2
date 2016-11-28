package com.asura.fui.page.view.html;

import com.asura.fui.page.data.FrontData;

public class HtmlNavi extends AbstractHtmlElement {
	public HtmlNavi() {
	}

	public HtmlNavi(FrontData paras) {
		super(paras);
	}

	public String getTag() {
		return "nav";
	}
}
