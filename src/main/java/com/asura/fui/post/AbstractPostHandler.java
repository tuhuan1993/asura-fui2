package com.asura.fui.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asura.fui.page.data.DataConverter;
import com.asura.fui.page.data.FrontData;

public abstract class AbstractPostHandler implements IPostHandler {

	@Override
	public boolean canHandle(String postId) {
		if (getCanHandleFormIds() != null) {
			for (String filter : getCanHandleFormIds()) {
				if (filter.equals(postId)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String redirect(HttpServletRequest request, HttpServletResponse response) {
		FrontData data = DataConverter.fromOnlyParameter(request);

		request.getSession().setAttribute(getAttribute(), data);

		String path = request.getHeader("Referer");

		if (path.endsWith("/")) {
			path = path.substring(0, path.length() - 1);
		}

		return path;
	}

	protected abstract String getAttribute();

	protected abstract String[] getCanHandleFormIds();

}
