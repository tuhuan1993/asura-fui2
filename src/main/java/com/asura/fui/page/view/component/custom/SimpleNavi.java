package com.asura.fui.page.view.component.custom;

import java.util.HashMap;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.AbstractUIComponent;
import com.asura.fui.page.view.component.data.DataNavi;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.HtmlA;
import com.asura.fui.page.view.html.HtmlDiv;
import com.asura.fui.page.view.html.HtmlSpan;
import com.asura.fui.page.view.html.IHtmlElement;
import com.asura.fui.util.ParameterUtil;

public class SimpleNavi extends AbstractUIComponent {
	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		DataNavi navi = (DataNavi) data;

		HtmlDiv div = new HtmlDiv(paras);
		div.addStyle("background", "rgb(204,204,204)");

		String url = getValue(navi.getUrl(), paras);

		HashMap<String, String> m = ParameterUtil.convert(url);

		for (String key : m.keySet()) {
			HtmlA a = new HtmlA(paras);
			a.addStyle("width", "100%");
			a.addStyle("float", "left");
			HtmlSpan span = new HtmlSpan(paras);
			span.setContent(key);

			a.addChild(span);

			div.addChild(a);
		}

		return div;
	}
}
