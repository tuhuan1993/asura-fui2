package com.asura.fui.page.view.component.data;

import com.asura.fui.page.PageFactory;
import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.HtmlDiv;
import com.asura.fui.page.view.html.IHtmlElement;
import com.asura.fui.util.ParameterUtil;
import com.asura.tools.util.StringUtil;

public class DataRef extends AbstractUIData {
	private String ref;

	public String getRef() {
		return this.ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public IHtmlElement toElement(IUILayout layout, FrontData paras) {
		String r = ParameterUtil.getValue(this.ref, paras);

		String[] ss = StringUtil.split(r, ",");

		IUIData data = null;
		if (ss.length == 2)
			// data = PageCache.getDataRef(ss[0].trim(), ss[1].trim());
			data = PageFactory.instance().getData(ss[1].trim());
		else {
			// data = PageCache.getDataRef("", r);
			data = PageFactory.instance().getData(r);
		}

		if (data == null) {
			return new HtmlDiv();
		}

		return data.toElement(layout, paras);
	}
}