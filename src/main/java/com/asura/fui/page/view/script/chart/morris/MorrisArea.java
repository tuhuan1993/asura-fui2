package com.asura.fui.page.view.script.chart.morris;

public class MorrisArea extends AbstractMorrisChart {

	@Override
	public String getChartType() {
		return "Area";
	}

	public String[] getOptions() {
		return new String[] { "behaveLikeLine: true" };
	}

}
