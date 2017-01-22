package com.google.clone.dao;

import java.util.List;

import com.google.clone.model.InformationModel;

public interface CloneDao {
	void saveToDb(String url, String keywords);
	List<InformationModel> getInfo(String key);
}