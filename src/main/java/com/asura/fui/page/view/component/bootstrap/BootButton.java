package com.asura.fui.page.view.component.bootstrap;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.AbstractUIComponent;
import com.asura.fui.page.view.component.data.DataInput;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.IHtmlElement;
import com.asura.fui.page.view.html.SimpleHtml;
import com.asura.tools.util.StringUtil;

public class BootButton extends AbstractUIComponent {
	private String type;
	private String style;

	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		DataInput p = (DataInput) data;

		SimpleHtml bt = new SimpleHtml("button", paras);
		if (p.isSubmit())
			bt.addAttr("type", "submit");
		else {
			bt.addAttr("type", "button");
		}
		bt.setContent(p.getLabel());
		if (StringUtil.isNullOrEmpty(this.type)) {
			this.type = "default";
		}
		bt.setClass("btn btn-" + this.type);

		addEvent(bt, p.getKey());

		addStyle(bt, this.style, paras);

		addStyle(bt, paras);

		addAttr(bt, paras);

		return bt;
	}
}
