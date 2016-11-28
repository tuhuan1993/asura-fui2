package com.asura.fui.page.view.script;

import java.util.ArrayList;
import java.util.List;

import com.asura.fui.page.data.FrontData;
import com.asura.tools.util.StringUtil;

public class ScriptCondition implements IUIScript {

	private String con;
	private List<IUIScript> scripts;

	public String getCon() {
		return this.con;
	}

	public void setCon(String con) {
		this.con = con;
	}

	public List<IUIScript> getScripts() {
		return this.scripts;
	}

	public void setScripts(List<IUIScript> scripts) {
		this.scripts = scripts;
	}

	@Override
	public String toScript(FrontData paras) {
		List<String> list = new ArrayList<>();
		for (IUIScript s : this.scripts) {
			list.add(s.toScript(paras));
		}
		return StringUtil.getStringFromStrings(list, "\n");
	}

}
