package com.asura.fui.page.view.component.bootstrap;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.AbstractUIComponent;
import com.asura.fui.page.view.component.data.DataProgress;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.HtmlDiv;
import com.asura.fui.page.view.html.IHtmlElement;
import com.asura.tools.util.StringUtil;

public class BootProgress extends AbstractUIComponent {
	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		DataProgress dp = (DataProgress) data;

		HtmlDiv div = new HtmlDiv(paras);
		div.setClass("progress");

		HtmlDiv pro = new HtmlDiv(paras);
		pro.setClass("progress-bar");
		pro.addStyle("width", dp.getPercent() + "%");

		if (StringUtil.isNullOrEmpty(dp.getCount()))
			pro.setContent(dp.getPercent() + "%");
		else {
			pro.setContent(dp.getCount());
		}

		addStyle(pro, paras);

		div.addChild(pro);

		return div;
	}
}
