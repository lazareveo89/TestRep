package com.test.searchplace.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.searchplace.model.Place;
import com.test.searchplace.model.Tag;
import com.test.searchplace.model.User;
import com.test.searchplace.service.PlaceService;

@RestController
public class MainController {
	
	@Autowired
	PlaceService placeService;

	//@RequestMapping(value = "/addPlace", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody List<Place> getResult(@RequestBody String user) {
		List<Place> list = new ArrayList<>();
		Place p = new Place();
		p.setNamePlace("PuzataHata");
		Tag t = new Tag();
		t.setNameTag("BBQ");
		Tag t2 = new Tag();
		t2.setNameTag("pizza");
		List<Tag> tags = new ArrayList<>();
		tags.add(t);
		tags.add(t2);
		p.setTags(tags);
		list.add(p);
		return list;
	}
	
	@RequestMapping(value = "/addPlace", method = RequestMethod.POST, headers="Accept=application/json")
	public void addPlace(@RequestBody Place place) {
		getPlaceService().createPlace(place);
	}
	
	public PlaceService getPlaceService() {
		return placeService;
	}
}