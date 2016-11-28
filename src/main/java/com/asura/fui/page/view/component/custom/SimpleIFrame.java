package com.asura.fui.page.view.component.custom;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.AbstractUIComponent;
import com.asura.fui.page.view.component.data.DataIFrame;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.IHtmlElement;
import com.asura.fui.page.view.html.SimpleHtml;

public class SimpleIFrame extends AbstractUIComponent {
	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		DataIFrame dif = (DataIFrame) data;

		SimpleHtml sh = new SimpleHtml("iframe", paras);
		sh.addAttr("src", dif.getSrc());

		addStyle(sh, paras);

		return sh;
	}
}