package com.asura.fui.page.view.component.data.basic;

import com.asura.fui.page.view.component.data.AbstractUIData;
import com.asura.tools.util.StringUtil;

public class DataImg extends AbstractUIData {
	private String url;
	private String alt;
	private String img;

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getAlt() {
		return this.alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public boolean isLink() {
		return (!(StringUtil.isNullOrEmpty(this.url)));
	}
}
