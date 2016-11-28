package com.asura.fui.init;

public abstract class AbstractInit implements InitListener {

	protected int priority;

	@Override
	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public int getPriority() {
		return this.priority;
	}

}
