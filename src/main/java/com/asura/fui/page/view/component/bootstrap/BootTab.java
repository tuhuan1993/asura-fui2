package com.asura.fui.page.view.component.bootstrap;

import java.util.HashMap;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.AbstractUIComponent;
import com.asura.fui.page.view.component.data.DataNavi;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.HtmlA;
import com.asura.fui.page.view.html.HtmlLi;
import com.asura.fui.page.view.html.HtmlUL;
import com.asura.fui.page.view.html.IHtmlElement;
import com.asura.fui.util.ParameterUtil;

public class BootTab extends AbstractUIComponent {
	private boolean pill;

	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		DataNavi navi = (DataNavi) data;

		HtmlUL ul = new HtmlUL(paras);

		if (this.pill)
			ul.addAttr("class", "nav nav-pills");
		else {
			ul.addAttr("class", "nav nav-tabs");
		}

		String url = getValue(navi.getUrl(), paras);

		HashMap<String, String> m = ParameterUtil.convert(url);

		for (String n : m.keySet()) {
			String u = (String) m.get(n);
			HtmlLi li = new HtmlLi(paras);
			if (n.equals(getValue(navi.getSelected(), paras))) {
				li.addAttr("class", "active");
			}
			HtmlA a = new HtmlA(paras);
			a.addAttr("href", u);
			a.setContent(n);
			li.addChild(a);
			ul.addChild(li);
		}

		return ul;
	}
}
