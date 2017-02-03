package com.test.searchplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.searchplace.dao.PlaceDao;
import com.test.searchplace.model.Place;
import com.test.searchplace.service.PlaceService;

public class PlaceServiceImpl implements PlaceService{
	
	@Autowired
	private PlaceDao placeDao;

	@Override
	public void createPlace(Place place) {
		getPlaceDao().createPlace(place);
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
	
	public PlaceDao getPlaceDao() {
		return placeDao;
	}

}
