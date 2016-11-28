package com.asura.fui.page.view.component.bootstrap;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.IUIComponent;
import com.asura.fui.page.view.component.data.DataBadge;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.HtmlA;
import com.asura.fui.page.view.html.HtmlDiv;
import com.asura.fui.page.view.html.HtmlSpan;
import com.asura.fui.page.view.html.IHtmlElement;
import com.asura.tools.util.StringUtil;

public class BootBadge implements IUIComponent {
	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		DataBadge p = (DataBadge) data;

		HtmlDiv div = new HtmlDiv(paras);
		HtmlA a = new HtmlA(paras);

		if (!(StringUtil.isNullOrEmpty(p.getUrl()))) {
			a.addAttr("href", p.getUrl());
		}

		a.setContent(p.getName());

		HtmlSpan span = new HtmlSpan(paras);
		span.setClass("badge");
		span.setContent(p.getCount());

		a.addChild(span);

		div.addChild(a);

		return div;
	}
}
