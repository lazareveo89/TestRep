package com.test.searchplace.model;

import java.util.List;

public class User {
	
	private String login;
	private List<Place> searchPlaces;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public List<Place> getSearchPlaces() {
		return searchPlaces;
	}
	public void setSearchPlaces(List<Place> searchPlaces) {
		this.searchPlaces = searchPlaces;
	}
}