package com.asura.fui.page.view.component.bootstrap;

import java.util.HashMap;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.AbstractUIComponent;
import com.asura.fui.page.view.component.data.DataButtonGroup;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.HtmlDiv;
import com.asura.fui.page.view.html.HtmlInput;
import com.asura.fui.page.view.html.IHtmlElement;
import com.asura.fui.util.ParameterUtil;
import com.asura.tools.util.StringUtil;

public class SimpleCheckBox extends AbstractUIComponent {
	private String click;
	private int ml;

	public String getClick() {
		return this.click;
	}

	public void setClick(String click) {
		this.click = click;
	}

	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		HtmlDiv div = new HtmlDiv();
		div.setClass("btn-group");

		DataButtonGroup dr = (DataButtonGroup) data;

		HashMap<String, String> map = ParameterUtil.convert(ParameterUtil.getValue(dr.getKeyLabels(), paras));

		HashMap<String, String> uMap = ParameterUtil.convert(ParameterUtil.getValue(dr.getKeyUrls(), paras));

		HashMap<String, String> dMap = ParameterUtil.convert(ParameterUtil.getValue(dr.getKeyDescs(), paras));

		int i = 0;
		for (String key : map.keySet()) {
			HtmlDiv out = new HtmlDiv();
			HtmlInput input = new HtmlInput();
			input.setType("checkbox");
			input.addAttr("name", dr.getGroup());
			input.setContent((String) map.get(key));
			input.addAttr("alt", (String) map.get(key));
			if (!(StringUtil.isNullOrEmpty((String) uMap.get(key)))) {
				input.addAttr("onclick", (String) uMap.get(key));
			}
			if (!(StringUtil.isNullOrEmpty((String) dMap.get(key)))) {
				input.addAttr("title", (String) dMap.get(key));
			}
			input.addAttr("id", key);
			input.addAttr("value", key);

			if (key.equals(getValue(dr.getSelected(), paras))) {
				input.addAttr("checked", "false");
			}

			addEvent(input, key);

			if ((this.ml > 0) && (i > 0)) {
				out.addStyle("margin-left", this.ml + "px");
			}
			if (!(StringUtil.isNullOrEmpty(this.click))) {
				input.addAttr("onclick", this.click);
			}

			out.addStyle("float", "left");
			out.addChild(input);

			div.addChild(out);
			++i;
		}

		return div;
	}
}
