package com.asura.fui.page.view.component.bootstrap;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.IUIComponent;
import com.asura.fui.page.view.component.data.DataChart;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.HtmlDiv;
import com.asura.fui.page.view.html.IHtmlElement;

public class BootChart implements IUIComponent {
	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		DataChart p = (DataChart) data;

		HtmlDiv div = new HtmlDiv(paras);
		div.addAttr("id", p.getKey());

		return div;
	}
}
