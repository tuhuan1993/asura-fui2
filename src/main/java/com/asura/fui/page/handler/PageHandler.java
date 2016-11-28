package com.asura.fui.page.handler;

import javax.servlet.http.HttpServletRequest;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.data.PageData;
import com.asura.fui.service.dispatch.FuiUrl;

public interface PageHandler extends Cloneable {

	public PageData buildData(FuiUrl url, FrontData data, HttpServletRequest request);

	public boolean isForward();

	public boolean isRedirect();

	public String forwardSuffix();

	public String redirectUrl();

	public PageHandler clone();

}
