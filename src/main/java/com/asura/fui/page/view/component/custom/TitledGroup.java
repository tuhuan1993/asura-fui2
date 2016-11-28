package com.asura.fui.page.view.component.custom;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.AbstractUIComponent;
import com.asura.fui.page.view.component.data.DataPanel;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.data.UIDatas;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.HtmlDiv;
import com.asura.fui.page.view.html.IHtmlElement;
import com.asura.fui.page.view.html.SimpleHtml;

public class TitledGroup extends AbstractUIComponent {
	private String headStyle;
	private String hrStyle;

	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		DataPanel p = (DataPanel) data;

		HtmlDiv panel = new HtmlDiv(paras);

		SimpleHtml h = new SimpleHtml("h3", paras);
		h.setContent(p.getHead());
		h.addStyle("width", "100%");
		addStyle(h, this.headStyle, paras);

		panel.addChild(h);

		HtmlDiv hr = new HtmlDiv();
		hr.addAttr("style", "border-top: 1px solid;color:#ccc; height: 1px; width:100%;float:left;");
		addStyle(hr, this.hrStyle, paras);

		panel.addChild(hr);

		HtmlDiv body = new HtmlDiv(paras);

		if (p.getChildren() != null) {
			UIDatas datas = new UIDatas();
			for (IUIData el : p.getChildren()) {
				datas.addUIData(el);
			}
			layout.toHtml(body, datas, paras, true);
		}

		panel.addChild(body);

		return panel;
	}
}
