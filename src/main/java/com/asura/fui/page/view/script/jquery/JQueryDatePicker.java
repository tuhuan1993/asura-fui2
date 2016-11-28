package com.asura.fui.page.view.script.jquery;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.script.IUIScript;
import com.asura.tools.util.StringUtil;

public class JQueryDatePicker implements IUIScript {
	private String id;
	private String format;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toScript(FrontData paras) {
		if (StringUtil.isNullOrEmpty(this.format)) {
			this.format = "yy-mm-dd";
		}
		return " $(document).ready(function() {\n$(\"#" + this.id + "\").datepicker({ dateFormat: '" + this.format
				+ "' }); \n });";
	}

}
