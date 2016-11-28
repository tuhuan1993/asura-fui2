package com.asura.fui.data;

import java.util.List;

import com.asura.fui.page.data.FrontData;
import com.asura.tools.data.DataRecord;

public interface IDataProvider extends Cloneable {

	public List<DataRecord> build(FrontData data);

	public void setCategory(String category);

	public void setKey(String key);

	public String getCategory();

	public String getKey();

	public void setParameters(String[] parameters);

	public String[] getParameters();

	public IDataProvider clone();
}
