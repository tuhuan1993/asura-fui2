package com.asura.fui.page.data.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.custom.ListViewUtil;
import com.asura.fui.service.dispatch.FuiUrl;
import com.asura.fui.util.ParameterUtil;
import com.asura.tools.data.DataRecord;
import com.asura.tools.data.mysql.MysqlHandler;
import com.asura.tools.sql.SelectSQL;

public class ParaMysqListViewBuilder extends AbstractParaBuilder {
	private String field;
	private String sql;
	private String datasource;
	private MysqlHandler handler;

	public MysqlHandler getHandler() {
		return handler;
	}

	public void setHandler(MysqlHandler handler) {
		this.handler = handler;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getSql() {
		return this.sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getDatasource() {
		return this.datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public FrontData build(FuiUrl url, FrontData data) {
		FrontData d = new FrontData();

		this.sql = ParameterUtil.getValue(this.sql, data);

		SelectSQL sql = new SelectSQL();
		sql.setSql(this.sql);
		List<DataRecord> list = this.handler.selectList(sql);

		List<FrontData> result = new ArrayList<>();
		if (list.size() > 0) {
			HashMap<String, String> m = ParameterUtil.convert(this.field);

			for (DataRecord dr : list) {
				FrontData subD = new FrontData();
				for (String key : m.keySet()) {
					subD.addField(key, ListViewUtil.getText(dr.getFieldValue((String) m.get(key))));
				}
				result.add(subD);
			}
		}

		d.addField(this.key, result);

		return d;
	}
}
