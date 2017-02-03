package com.test.searchplace.dao;

import java.util.List;

import com.test.searchplace.model.Place;

public interface PlaceDao {
	void createPlace(Place place);
	List<Place> getPlace(String name);
	void updatePlace(Place place);
	void deletePlace(Place place);
}