package com.asura.fui.page.handler;

import com.asura.tools.util.StringUtil;

public abstract class AbstractPageHandler implements PageHandler {

	private String forwardSuffix;

	private String redirectUrl;

	@Override
	public boolean isForward() {
		return !StringUtil.isNullOrEmpty(forwardSuffix);
	}

	@Override
	public boolean isRedirect() {
		return !StringUtil.isNullOrEmpty(redirectUrl);
	}

	@Override
	public String forwardSuffix() {
		return forwardSuffix;
	}

	@Override
	public String redirectUrl() {
		return redirectUrl;
	}

	protected void forward(String forwardSuffix) {
		this.forwardSuffix = forwardSuffix;
	}

	protected void redirect(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	@Override
	public PageHandler clone() {
		PageHandler pg = null;
		try {
			pg = (PageHandler) super.clone();
		} catch (Exception e) {
			pg = null;
		}
		return pg;
	}
}
