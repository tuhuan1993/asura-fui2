package com.asura.fui.page.view.component.custom;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.AbstractUIComponent;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.data.basic.DataText;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.IHtmlElement;
import com.asura.fui.page.view.html.SimpleHtml;
import com.asura.tools.util.StringUtil;

public class SimpleText extends AbstractUIComponent {
	private boolean multi;
	private String tag;
	private String desc;

	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		DataText text = (DataText) data;
		if (StringUtil.isNullOrEmpty(this.tag)) {
			this.tag = "span";
		}
		if (this.multi) {
			SimpleHtml span = new SimpleHtml("p", text.getText(), paras);
			addStyle(span, paras);

			return span;
		}
		SimpleHtml span = new SimpleHtml(this.tag, text.getText(), paras);
		addStyle(span, paras);
		if (!(StringUtil.isNullOrEmpty(this.desc))) {
			span.addAttr("title", this.desc);
		}

		return span;
	}

	public boolean isMulti() {
		return this.multi;
	}

	public void setMulti(boolean multi) {
		this.multi = multi;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
