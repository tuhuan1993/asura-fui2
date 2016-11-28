package com.asura.fui.page.view.component.data;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.IHtmlElement;

public interface IUIData {
	public String getKey();

	public void setKey(String paramString);

	public IHtmlElement toElement(IUILayout paramIUILayout, FrontData paramFrontData);
}
