package com.asura.fui.page.view.component;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.IHtmlElement;

public interface IUIComponent {
	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras);
}
