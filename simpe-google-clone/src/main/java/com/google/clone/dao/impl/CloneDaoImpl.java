package com.google.clone.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.google.clone.dao.CloneDao;
import com.google.clone.model.InformationModel;
import com.google.clone.model.InformationModelRowMapper;

public class CloneDaoImpl implements CloneDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void saveToDb(String url, String keywords) {
		jdbcTemplate.update("INSERT INTO urlsInfo (url, keywords) VALUES (?, ?)", url, keywords);
	}

	@Override
	public List<InformationModel> getInfo(String key) {
		List<InformationModel> list = jdbcTemplate.query("SELECT url,keywords FROM urlsInfo "
				+ "WHERE keywords LIKE ?",new InformationModelRowMapper() ,"%"+key+"%");
		return list;
	}
}