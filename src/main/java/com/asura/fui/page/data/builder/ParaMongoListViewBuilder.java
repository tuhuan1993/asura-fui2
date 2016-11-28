package com.asura.fui.page.data.builder;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.asura.fui.page.data.FrontData;
import com.asura.fui.page.view.component.custom.ListViewUtil;
import com.asura.fui.service.dispatch.FuiUrl;
import com.asura.fui.util.ParameterUtil;
import com.asura.tools.data.DataRecord;
import com.asura.tools.data.mongo.MongoHandler;
import com.asura.tools.sql.SelectSQL;
import com.asura.tools.util.StringUtil;
import com.asura.tools.util.math.NumberUtil;

public class ParaMongoListViewBuilder extends AbstractParaBuilder {
	private String field;
	private String db;
	private SelectSQL sql;
	private String datasource;
	private MongoHandler handler;

	public void setMongoHandler(MongoHandler handler) {
		this.handler = handler;
	}

	public MongoHandler getMongoHandler() {
		return this.handler;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDb() {
		return this.db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public SelectSQL getSql() {
		return this.sql;
	}

	public void setSql(SelectSQL sql) {
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

		List<DataRecord> list = this.handler.selectList(this.db, this.sql);

		List<FrontData> result = new ArrayList<>();
		if (list.size() > 0) {
			HashMap<String, String> m = ParameterUtil.convert(this.field);

			for (DataRecord dr : list) {
				FrontData subD = new FrontData();
				for (String key : m.keySet()) {
					Object tmp = dr.getFieldObject((String) m.get(key));
					if (tmp != null && tmp instanceof Date) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						subD.addField(key, ListViewUtil.getText(getLenghed(sdf.format((Date) tmp))));
					} else {
						subD.addField(key, ListViewUtil.getText(getLenghed(dr.getFieldValue((String) m.get(key)))));
					}

				}
				result.add(subD);
			}
		}

		d.addField(this.key, result);

		return d;
	}

	private String getLenghed(String v) {
		if ((!(StringUtil.isNullOrEmpty(v))) && (StringUtil.isNumberString(v))) {
			if (NumberUtil.getDouble(v) > 1.0D) {
				return NumberUtil.getLenedDouble(NumberUtil.getDouble(v), 2);
			}
			return NumberUtil.getLenedDouble(NumberUtil.getDouble(v), 4);
		}

		try {
			double d = new BigDecimal(v).doubleValue();
			return NumberUtil.getLenedDouble(d, 4);
		} catch (Exception localException) {
		}
		return v;
	}
}
