package com.asura.fui.page.view.html;

import com.asura.fui.page.data.FrontData;

public class HtmlImg extends AbstractHtmlElement {
	public HtmlImg() {
	}

	public HtmlImg(FrontData paras) {
		super(paras);
	}

	public String getTag() {
		return "img";
	}

	public void setSrc(String src) {
		addAttr("src", src);
	}

	public void setAlt(String alt) {
		addAttr("alt", alt);
	}
}
