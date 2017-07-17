package com.test.searchplace.service;

import java.util.List;

import com.test.searchplace.model.Place;

public interface PlaceService {
	void createPlace(Place place);
	List<Place> getPlace(String name);
	void updatePlace(Place place);
	void deletePlace(Place place);
}
