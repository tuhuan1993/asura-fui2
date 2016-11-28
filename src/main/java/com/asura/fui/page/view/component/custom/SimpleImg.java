package com.asura.fui.page.view.component.custom;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.AbstractUIComponent;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.data.basic.DataImg;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.HtmlA;
import com.asura.fui.page.view.html.HtmlImg;
import com.asura.fui.page.view.html.IHtmlElement;

public class SimpleImg extends AbstractUIComponent {
	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		DataImg img = (DataImg) data;

		HtmlImg hi = new HtmlImg(paras);
		hi.setAlt(img.getAlt());
		hi.setSrc(img.getImg());

		if (img.isLink()) {
			HtmlA a = new HtmlA(paras);
			a.setUrl(img.getUrl());
			a.addChild(hi);

			return a;
		}

		return hi;
	}
}
