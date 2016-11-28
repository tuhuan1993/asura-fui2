package com.asura.fui.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asura.fui.config.IM;
import com.asura.fui.config.PropertyConfigManager;

public class DispatchService extends HttpServlet {

	private static final long serialVersionUID = 8311310059441952827L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf8");

		String uri = request.getServletPath();
		String pathInfo = request.getPathInfo();

		if (pathInfo != null && pathInfo.length() > 0) {
			uri = uri + pathInfo;
		}

		request.getSession().setAttribute("url-suffix", uri);

		request.getSession().getServletContext()
				.getRequestDispatcher(PropertyConfigManager.getSettingProperty(IM.PROPERTY_PAGE_URL))
				.forward(request, response);
	}

}
