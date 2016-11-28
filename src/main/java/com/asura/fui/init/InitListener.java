package com.asura.fui.init;

import javax.servlet.ServletContextEvent;

public interface InitListener {

	public void init(ServletContextEvent context) throws Exception;

	public void destroy(ServletContextEvent context);

	public void setPriority(int priority);

	public int getPriority();

}
