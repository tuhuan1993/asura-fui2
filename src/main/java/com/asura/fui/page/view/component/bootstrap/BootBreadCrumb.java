package com.asura.fui.page.view.component.bootstrap;

import java.util.HashMap;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.IUIComponent;
import com.asura.fui.page.view.component.data.DataNavi;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.HtmlA;
import com.asura.fui.page.view.html.HtmlLi;
import com.asura.fui.page.view.html.HtmlOl;
import com.asura.fui.page.view.html.IHtmlElement;
import com.asura.fui.util.ParameterUtil;

public class BootBreadCrumb implements IUIComponent {
	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		DataNavi navi = (DataNavi) data;

		HtmlOl ul = new HtmlOl(paras);
		ul.addAttr("class", "breadcrumb");

		String url = getValue(navi.getUrl(), paras);

		HashMap<String, String> m = ParameterUtil.convert(url);

		for (String n : m.keySet()) {
			String u = (String) m.get(n);
			HtmlLi li = new HtmlLi(paras);
			if (n.equals(navi.getSelected())) {
				li.addAttr("class", "active");
				li.setContent(n);
			} else {
				HtmlA a = new HtmlA(paras);
				a.addAttr("href", u);
				a.setContent(n);
				li.addChild(a);
			}
			ul.addChild(li);
		}

		return ul;
	}

	private String getValue(String value, FrontData paras) {
		String t = value;
		for (String p : paras.getAllFields()) {
			t = t.replace("$" + p + "$", paras.getValueString(p));
		}
		return t;
	}
}
