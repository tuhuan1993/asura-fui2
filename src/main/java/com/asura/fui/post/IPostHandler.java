package com.asura.fui.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IPostHandler {

	public boolean canHandle(String postId);

	public String redirect(HttpServletRequest request, HttpServletResponse response);

}
