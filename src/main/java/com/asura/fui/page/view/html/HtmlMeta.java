package com.asura.fui.page.view.html;

import com.asura.fui.page.data.FrontData;

public class HtmlMeta extends AbstractHtmlElement {
	public HtmlMeta() {
	}

	public HtmlMeta(FrontData paras) {
		super(paras);
	}

	public HtmlMeta(String name, String content, FrontData paras) {
		super(paras);
		addAttr("name", name);
		addAttr("content", content);
	}

	public String getTag() {
		return "meta";
	}
}
