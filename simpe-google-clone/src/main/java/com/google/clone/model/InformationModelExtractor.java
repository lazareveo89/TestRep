package com.google.clone.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class InformationModelExtractor implements ResultSetExtractor<InformationModel>{

	@Override
	public InformationModel extractData(ResultSet res) throws SQLException, DataAccessException {
		InformationModel infModel = new InformationModel();
		infModel.setUrl(res.getString("url"));
		infModel.setKeywords(res.getString("keywords"));
		return infModel;
	}

}
