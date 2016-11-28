package com.asura.fui.page.view.script;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.util.ParameterUtil;

public class ScriptAssign implements IUIScript {

	private String name;
	private String value;
	private boolean first;
	private boolean quote;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isFirst() {
		return this.first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	@Override
	public String toScript(FrontData paras) {
		String v = ParameterUtil.getValue(this.value, paras);
		if (this.quote) {
			v = "'" + v + "'";
		}
		if (this.first) {
			return "var " + this.name + " = " + v + ";";
		}
		return this.name + " = " + v + ";";
	}

}
