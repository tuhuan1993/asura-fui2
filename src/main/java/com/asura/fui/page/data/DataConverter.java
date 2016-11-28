package com.asura.fui.page.data;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataConverter {

	private static Logger logger = LoggerFactory.getLogger(DataConverter.class);

	// default needs to set utf8 in container's web.xml, no need to encoder in
	// the codes
	public static FrontData fromParameter(HttpServletRequest request) {
		return fromParameter(request, false);
	}

	public static FrontData fromParameter(HttpServletRequest request, boolean encoder) {
		FrontData data = new FrontData();
		for (Iterator<?> localIterator = request.getParameterMap().keySet().iterator(); localIterator.hasNext();) {
			Object name = localIterator.next();
			if (encoder) {
				try {
					data.addField((String) name,
							new String(request.getParameter((String) name).getBytes("ISO-8859-1"), "UTF8"));
				} catch (UnsupportedEncodingException e) {
					logger.error("error happens in encoder process", e);
				}
			} else {
				data.addField((String) name, request.getParameter((String) name));
			}
		}

		Enumeration<?> en = request.getSession().getAttributeNames();
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			data.addField(name, request.getSession().getAttribute(name));
		}
		return data;
	}

	public static FrontData fromOnlyParameter(HttpServletRequest request) {
		FrontData data = new FrontData();
		for (Iterator<?> localIterator = request.getParameterMap().keySet().iterator(); localIterator.hasNext();) {
			Object name = localIterator.next();
			try {
				data.addField((String) name,
						new String(request.getParameter((String) name).getBytes("ISO-8859-1"), "UTF8"));
			} catch (UnsupportedEncodingException e) {
				logger.error("error happens in encoder process", e);
			}
		}

		return data;
	}

}
