package com.asura.fui.page.view.script.chart;

public class ChartSimpleProvider implements IChartProvider {

	private String label;
	private String dataVar;
	private String keyName;
	private String valueNames;
	private String xLabels;

	@Override
	public ChartData provide() {
		ChartData cd = ChartData.fromString("", "", this.label);
		cd.setKeyName(this.keyName);
		cd.setValueNames(this.valueNames);
		cd.setDataVar(this.dataVar);
		cd.setxLabels(this.xLabels);

		return cd;
	}
	
	public String getxLabels() {
		return this.xLabels;
	}

	public void setxLabels(String xLabels) {
		this.xLabels = xLabels;
	}

	public String getDataVar() {
		return this.dataVar;
	}

	public void setDataVar(String dataVar) {
		this.dataVar = dataVar;
	}

	public String getKeyName() {
		return this.keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getValueNames() {
		return this.valueNames;
	}

	public void setValueNames(String valueNames) {
		this.valueNames = valueNames;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
