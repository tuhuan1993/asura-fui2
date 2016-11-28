package com.asura.fui.page.view.script;

import java.util.ArrayList;
import java.util.List;

import com.asura.fui.page.data.FrontData;
import com.asura.tools.util.StringUtil;

public class ScriptParaMapping implements IUIScript {

	private List<ParaMapping> mappings;

	public ScriptParaMapping() {
		this.mappings = new ArrayList<>();
	}

	public void addDataMapping(ParaMapping mapping) {
		this.mappings.add(mapping);
	}

	@Override
	public String toScript(FrontData paras) {
		String s = "";
		List<String> initials = new ArrayList<>();
		String ini;
		for (ParaMapping pm : this.mappings) {
			for (String toKey : pm.getToMap().keySet()) {
				ini = "var " + toKey + "='';";
				if (!(initials.contains(ini))) {
					initials.add(ini);
				}
			}
		}

		s = StringUtil.getStringFromStrings(initials, "\n") + "\n";

		for (ParaMapping pm : this.mappings) {
			s = s + "if(";
			List<String> con = new ArrayList<>();
			for (String fromKey : pm.getFromMap().keySet()) {
				con.add(fromKey + " == '" + pm.getFromMap().get(fromKey) + "'");
			}
			s = s + StringUtil.getStringFromStrings(con, " && ") + "){\n";

			List<String> set = new ArrayList<>();
			for (String toKey : pm.getToMap().keySet()) {
				set.add(toKey + "= '" + pm.getToMap().get(toKey) + "';");
			}
			s = s + StringUtil.getStringFromStrings(set, "\n");
			s = s + "\n}\n";
		}

		return s;
	}

}
