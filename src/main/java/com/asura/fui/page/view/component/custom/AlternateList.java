package com.asura.fui.page.view.component.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.AbstractUIComponent;
import com.asura.fui.page.view.component.data.AlternateDataList;
import com.asura.fui.page.view.component.data.IUIData;
import com.asura.fui.page.view.component.layout.IUILayout;
import com.asura.fui.page.view.html.HtmlDiv;
import com.asura.fui.page.view.html.IHtmlElement;
import com.asura.fui.page.view.html.SimpleHtml;
import com.asura.fui.util.ParameterUtil;
import com.asura.tools.data.DataRecord;
import com.asura.tools.util.StringUtil;

public class AlternateList extends AbstractUIComponent {
	private String wrapNode;
	private String wrapNodeAttrs;
	private int row;
	private int column;
	private String hrStyle;

	public int getRow() {
		return this.row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return this.column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String getHrStyle() {
		return this.hrStyle;
	}

	public void setHrStyle(String hrStyle) {
		this.hrStyle = hrStyle;
	}

	public IHtmlElement toHtml(IUIData data, IUILayout layout, FrontData paras) {
		AlternateDataList list = (AlternateDataList) data;
		IHtmlElement div = null;
		if (StringUtil.isNullOrEmpty(this.wrapNode))
			div = new HtmlDiv(paras);
		else {
			div = new SimpleHtml(this.wrapNode);
		}

		if (!(StringUtil.isNullOrEmpty(this.wrapNodeAttrs))) {
			HashMap<String, String> sMap = ParameterUtil.convert(this.wrapNodeAttrs);
			for (String key : sMap.keySet()) {
				if (StringUtil.isNullOrEmpty((String) sMap.get(key)))
					div.addAttr(key, null);
				else {
					div.addAttr(key, (String) sMap.get(key));
				}
			}

		}

		List<IHtmlElement> els = new ArrayList<>();

		int i = 0;
		for (DataRecord dr : list.getProvider().build(paras)) {
			IUIData d = null;
			if (i % 2 > 0)
				d = list.getAlterData();
			else {
				d = list.getData();
			}

			FrontData newParas = paras.clone();
			for (String f : dr.getAllFields()) {
				newParas.addField(f, dr.getFieldValue(f));
			}
			els.add(d.toElement(layout, newParas));
			++i;
		}

		layout.handleList(div, list.getKey(), els, list.getData().getKey(), this.row, this.column, paras, this.hrStyle);

		return div;
	}
}