package com.asura.fui.page.view.script.chart.dragon;

public class DragonLine extends AbstractDragonChart {
	private String suffix;

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public String getChartType() {
		return "Line";
	}

	public String[] getOptions() {
		return new String[] {
				"outerLabel:{content: function(data) {return data.text + ' ' + data.value + '" + this.suffix + "';}}",
				"click: function(data,e){" + this.click + "}" };
	}

}
