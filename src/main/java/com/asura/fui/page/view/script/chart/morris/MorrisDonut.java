package com.asura.fui.page.view.script.chart.morris;

import java.util.ArrayList;
import java.util.List;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.script.chart.ChartData;
import com.asura.tools.util.StringUtil;

public class MorrisDonut extends AbstractMorrisChart {

	@Override
	public String getChartType() {
		return "Donut";
	}

	@Override
	public String toScript(FrontData paras) {
		ChartData chart = this.provider.provide();
		String s = "";

		s = s + "Morris." + getChartType() + "({\n";

		List<String> list = new ArrayList<>();
		list.add("  element: '" + this.id + "'");
		if (chart.isNoData())
			list.add("  data: " + chart.toData());
		else {
			list.add("  data: " + toData(chart));
		}

		s = s + StringUtil.getStringFromStrings(list, ",\n");

		s = s + "\n});";
		return s;
	}

	private String toData(ChartData chart) {
		String s = "[\n";

		List<String> list = new ArrayList<>();

		for (String key : chart.getKeys()) {
			String[] vs = chart.getValues(key);
			List<String> subs = new ArrayList<>();

			subs.add("label: '" + key + "'");

			list.add("    { value: '" + vs[0] + "', " + StringUtil.getStringFromStrings(subs, ", ") + "}");
		}

		s = s + StringUtil.getStringFromStrings(list, ",\n") + "\n    ]";

		return s;
	}

	public String[] getOptions() {
		return new String[0];
	}

}
