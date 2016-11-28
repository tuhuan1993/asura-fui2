package com.asura.fui.page.handler.annotation;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.data.PageData;
import com.asura.fui.page.handler.AbstractPageHandler;
import com.asura.fui.page.handler.PageHandler;
import com.asura.fui.service.dispatch.FuiUrl;
import com.asura.tools.annotation.parser.AnnotationParserFactoryBuilder;

public class TestPHAnnotation {

	@Test
	public void test() throws Exception {
		PHAnnotationParserFactory factory = new AnnotationParserFactoryBuilder.Builder<PHAnnotationParserFactory>(
				"com.asura.fui.page.handler.annotation").build(PH.class, new PHAnnotationParserFactory());

		System.out.println(factory.getHandler("com.asura.fui.page.handler.annotation.Task1"));
		System.out.println(factory.getHandler("com.asura.fui.page.handler.annotation.Task2"));
		PageHandler hhh = factory.getHandler("aaaa").clone();
		System.out.println(hhh);
	}

	@PH
	public static class Task1 extends AbstractPageHandler {

		@Override
		public PageData buildData(FuiUrl fuiUrl, FrontData paras, HttpServletRequest request) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	@PH(alias = "aaaa")
	public static class Task2 extends AbstractPageHandler {

		@Override
		public PageData buildData(FuiUrl fuiUrl, FrontData paras, HttpServletRequest request) {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
