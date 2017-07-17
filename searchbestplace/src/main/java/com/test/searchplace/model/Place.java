package com.test.searchplace.model;

import java.util.List;

public class Place {
	
	private String namePlace;
	private List<Tag> tags;
	
	public String getNamePlace() {
		return namePlace;
	}
	public void setNamePlace(String namePlace) {
		this.namePlace = namePlace;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}