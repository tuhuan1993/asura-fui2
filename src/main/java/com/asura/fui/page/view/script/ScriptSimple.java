package com.asura.fui.page.view.script;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.util.ParameterUtil;

public class ScriptSimple implements IUIScript {

	private String script;

	public String getScript() {
		return this.script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	@Override
	public String toScript(FrontData paras) {
		if (!(this.script.trim().endsWith(";"))) {
			this.script += ";";
		}

		return ParameterUtil.getValue(this.script, paras);
	}

}
