package com.google.clone.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class InformationModelRowMapper implements RowMapper<InformationModel>{

	@Override
	public InformationModel mapRow(ResultSet res, int arg1) throws SQLException {
		InformationModelExtractor infModelExtract = new InformationModelExtractor();
		return infModelExtract.extractData(res);
	}

}
