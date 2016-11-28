package com.asura.fui.page.view.component.custom;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.html.HtmlDiv;

public class ListViewSimpleColumn implements IListViewColumn {
	public void decorate(HtmlDiv column, FrontData data, int index) {
		if (index++ % 2 == 1)
			column.addStyle("background-color", "#dddddd");
		else
			column.addStyle("background-color", "rgb(242,242,242)");
	}
}
