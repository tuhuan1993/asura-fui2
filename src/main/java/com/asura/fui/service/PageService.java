package com.asura.fui.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.asura.fui.config.PropertyConfigManager;
import com.asura.fui.page.HandlerFactory;
import com.asura.fui.page.PageFactory;
import com.asura.fui.page.data.DataConverter;
import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.data.PageData;
import com.asura.fui.page.handler.PageHandler;
import com.asura.fui.page.view.FuiPage;
import com.asura.fui.service.dispatch.FuiUrl;
import com.asura.fui.util.ParameterUtil;
import com.asura.fui.util.ServiceUtil;
import com.asura.tools.util.ExceptionUtil;
import com.asura.tools.util.StringUtil;

public class PageService extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(PageService.class);

	private static final long serialVersionUID = -5164872685520450152L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String path = (String) request.getSession().getAttribute("url-suffix");
		if (path == null) {
			request.getSession().getServletContext().getRequestDispatcher("/").forward(request, response);
			return;
		}

		path = new String(path.getBytes("ISO-8859-1"), "UTF8");

		String fuiPagePath = ParameterUtil.getPagePath(path);

		if (StringUtil.isNullOrEmpty(fuiPagePath)) {
			logger.warn("fui page path is empty " + path);
			request.getSession().getServletContext().getRequestDispatcher("/").forward(request, response);
			return;
		}

		FuiUrl url = new FuiUrl(request.getServerName(), request.getContextPath(), request.getServerPort(), path);

		response.setCharacterEncoding("utf8");

		FrontData paras = new FrontData();

		for (String key : PropertyConfigManager.getPropertyKeys()) {
			paras.addField(key, PropertyConfigManager.getSettingProperty(key));
		}

		paras.merge(DataConverter.fromParameter(request));

		paras.addField("fui-url", url);
		paras.addField("server", url.toUrlBase());

		FuiPage fuiPage = PageFactory.instance().getPage(fuiPagePath);

		if (fuiPage == null) {
			logger.warn("fui page is null with path:" + path);
			request.getSession().getServletContext().getRequestDispatcher("/").forward(request, response);
			return;
		}
		String content = "";
		try {
			if (StringUtil.isNullOrEmpty(fuiPage.getHandler())) {
				logger.info("without handler to html start " + url);
				content = fuiPage.toHtml(paras);
				logger.info("without handler to html end " + url);
			} else {
				PageHandler handler = HandlerFactory.instance().getHandler(fuiPage.getHandler());
				if (handler != null) {
					logger.info("with handler build data " + url);
					PageData pd = handler.buildData(url, paras, request);
					if (pd != null) {
						paras.merge(pd.getPageData(url, paras));
					}
					logger.info("with handler build data end " + url);
					content = fuiPage.toHtml(paras);
					logger.info("with handler to html end " + url);
				} else {
					content = "handler " + fuiPage.getHandler() + " does not exists!";
				}
			}
		} catch (Exception e) {
			content = ExceptionUtil.getExceptionContent(e);
		}

		ServiceUtil.output(content, response);
	}

}
