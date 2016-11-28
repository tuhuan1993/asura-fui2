package com.asura.fui.page.view.component.custom;

import java.util.HashMap;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.AbstractUIComponent;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.HtmlDiv;
import com.asura.fui.page.view.html.IHtmlElement;
import com.asura.fui.util.ParameterUtil;
import com.asura.tools.util.StringUtil;

public class SimpleDiv extends AbstractUIComponent {
	private String styles;
	private String attrs;

	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		HtmlDiv div = new HtmlDiv();

		if (!(StringUtil.isNullOrEmpty(this.styles))) {
			HashMap<String, String> sMap = ParameterUtil.convert(this.styles);
			for (String key : sMap.keySet()) {
				div.addStyle(key, (String) sMap.get(key));
			}
		}

		if (!(StringUtil.isNullOrEmpty(this.attrs))) {
			HashMap<String, String> sMap = ParameterUtil.convert(this.attrs);
			for (String key : sMap.keySet()) {
				div.addAttr(key, (String) sMap.get(key));
			}
		}

		return div;
	}
}
