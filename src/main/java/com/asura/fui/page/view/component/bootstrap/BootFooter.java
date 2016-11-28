package com.asura.fui.page.view.component.bootstrap;

import java.util.HashMap;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.IUIComponent;
import com.asura.fui.page.view.component.bootstrap.BootNavi.NaviPos;
import com.asura.fui.page.view.component.data.DataFooter;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.HtmlA;
import com.asura.fui.page.view.html.HtmlDiv;
import com.asura.fui.page.view.html.HtmlFooter;
import com.asura.fui.page.view.html.HtmlLi;
import com.asura.fui.page.view.html.HtmlUL;
import com.asura.fui.page.view.html.IHtmlElement;
import com.asura.fui.util.ParameterUtil;
import com.asura.tools.util.StringUtil;

public class BootFooter implements IUIComponent {

	private NaviPos pos;
	private boolean fluid;
	private boolean inverse;

	public NaviPos getPos() {
		return pos;
	}

	public void setPos(NaviPos pos) {
		this.pos = pos;
	}

	public boolean isFluid() {
		return fluid;
	}

	public void setFluid(boolean fluid) {
		this.fluid = fluid;
	}

	public boolean isInverse() {
		return inverse;
	}

	public void setInverse(boolean inverse) {
		this.inverse = inverse;
	}

	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		DataFooter df = (DataFooter) data;

		HtmlFooter footerbar = new HtmlFooter(paras);

		footerbar.addAttr("class", "navbar navbar-inverse");

		String type = "default";

		if (this.inverse) {
			type = "inverse";
		}

		if (this.pos == NaviPos.Bottom)
			footerbar.addAttr("class", "navbar navbar-" + type + " navbar-fixed-bottom");
		else if (this.pos == NaviPos.Top)
			footerbar.addAttr("class", "navbar navbar-" + type + " navbar-fixed-top");
		else {
			footerbar.addAttr("class", "navbar navbar-" + type);
		}

		HtmlDiv div_out = new HtmlDiv(paras);

		if (this.fluid)
			div_out.addAttr("class", "container-fluid");
		else {
			div_out.addAttr("class", "container");
		}

		footerbar.addChild(div_out);

		HtmlDiv middle = new HtmlDiv(paras);
		middle.addAttr("class", "collapse navbar-collapse");

		div_out.addChild(middle);

		HtmlUL content = new HtmlUL(paras);
		content.addAttr("class", "nav navbar-nav navbar-left");
		content.addStyle("margin-left", "200px");
		middle.addChild(content);

		String url = getValue(df.getUrl(), paras);

		HashMap<String, String> m = ParameterUtil.convert(getValue(url, paras));

		for (String key : m.keySet()) {
			HtmlLi li = new HtmlLi(paras);

			IHtmlElement input = new HtmlA(paras);
			if (!StringUtil.isNullOrEmpty(m.get(key))) {
				input.addAttr("href", m.get(key));
			}
			input.setContent(getValue(key, paras));

			li.addChild(input);
			content.addChild(li);
		}

		/*
		 * for (String key : lmap.keySet()) { HtmlLi li = new HtmlLi(paras);
		 * 
		 * IHtmlElement input = null; if ((utMap.containsKey(key)) &&
		 * ((utMap.get(key)).equals("button"))) { input = new HtmlA(paras);
		 * input.addAttr("class", "btn btn-info"); input.addAttr("onclick",
		 * "javascript:window.open('" + (uMap.get(key)) + "');"); } else if
		 * ((utMap.containsKey(key)) && ((utMap.get(key)).equals("button-js")))
		 * { input = new SimpleHtml("button", paras); input.addAttr("type",
		 * "button"); input.addAttr("onclick", (String) uMap.get(key)); } else
		 * if ((utMap.containsKey(key)) && ((utMap.get(key)).equals("link"))) {
		 * input = new HtmlA(paras); input.addAttr("href", uMap.get(key)); }
		 * else { input = new HtmlSpan(); } input.setContent(lmap.get(key));
		 * li.addChild(input); content.addChild(li); }
		 */
		return footerbar;
	}

	private String getValue(String value, FrontData paras) {
		if (value == null) {
			value = "";
		}
		String t = value;
		for (String p : paras.getAllFields()) {
			t = t.replace("$" + p + "$", paras.getValueString(p));
		}
		return t;
	}

}
