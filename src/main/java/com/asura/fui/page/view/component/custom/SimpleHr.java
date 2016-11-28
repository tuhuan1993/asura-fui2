package com.asura.fui.page.view.component.custom;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.AbstractUIComponent;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.HtmlDiv;
import com.asura.fui.page.view.html.IHtmlElement;

public class SimpleHr extends AbstractUIComponent {
	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		HtmlDiv div = new HtmlDiv();

		div.addAttr("style", "border-top: 1px solid;color:#ccc; height: 1px; width:100%;float:left;");

		addStyle(div, paras);

		return div;
	}
}
