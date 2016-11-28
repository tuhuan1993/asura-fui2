package com.asura.fui.page.view.component.layout;

import java.util.List;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.data.UIDatas;
import com.asura.fui.page.view.html.IHtmlElement;

public interface IUILayout {

	public void merge(IUILayout layout);

	public IHtmlElement toHtml(UIDatas datas, FrontData paras);

	public void toHtml(IHtmlElement parent, UIDatas datas, FrontData paras, boolean unique);

	public void handleList(IHtmlElement parent, String parentKey, List<IHtmlElement> children, String childKey, int row,
			int column, FrontData paras, String hrStyle);
}
