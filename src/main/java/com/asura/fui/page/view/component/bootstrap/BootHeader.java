package com.asura.fui.page.view.component.bootstrap;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.AbstractUIComponent;
import com.asura.fui.page.view.component.data.DataHeader;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.HtmlDiv;
import com.asura.fui.page.view.html.IHtmlElement;
import com.asura.fui.page.view.html.SimpleHtml;
import com.asura.tools.util.StringUtil;

public class BootHeader extends AbstractUIComponent {
	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		DataHeader header = (DataHeader) data;

		HtmlDiv div = new HtmlDiv(paras);
		div.setClass("page-header");
		div.addStyle("overflow", "hidden");

		if (!(StringUtil.isNullOrEmpty(header.getBackPic()))) {
			div.addStyle("background", "url(" + header.getBackPic() + ") repeat top left scroll");
		}

		SimpleHtml h1 = new SimpleHtml("h1", header.getTitle(), paras);

		div.addChild(h1);

		h1.addChild(new SimpleHtml("br"));

		if (!(StringUtil.isNullOrEmpty(header.getDesc()))) {
			SimpleHtml s = new SimpleHtml("small", header.getDesc(), paras);
			h1.addChild(s);
		}

		return div;
	}
}
