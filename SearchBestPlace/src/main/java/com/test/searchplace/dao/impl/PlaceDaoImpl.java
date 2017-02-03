package com.test.searchplace.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.test.searchplace.dao.PlaceDao;
import com.test.searchplace.model.Place;
import com.test.searchplace.model.Tag;

public class PlaceDaoImpl implements PlaceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void createPlace(Place place) {
		StringBuilder sb = new StringBuilder();
		List<Tag> list = place.getTags();
		for(Tag t : list) {
			sb.append(t.getNameTag());
		}
		jdbcTemplate.update("INSERT INTO place (place_name, tag_name) VALUES (?, ?)", place.getNamePlace(), sb.toString());		
	}

	@Override
	public List<Place> getPlace(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePlace(Place place) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePlace(Place place) {
		// TODO Auto-generated method stub
		
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

}