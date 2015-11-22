package com.test.supportech.model;

import java.util.Date;

public class Department {
	private Long id;
    private String depName;
    private String depAddr;
    private Integer rating;
    private Date depCreate;
    private Boolean depState;
    private String about;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getDepAddr() {
		return depAddr;
	}
	public void setDepAddr(String depAddr) {
		this.depAddr = depAddr;
	}
	public Date getDepCreate() {
		return depCreate;
	}
	public void setDepCreate(Date depCreate) {
		this.depCreate = depCreate;
	}
	public Boolean getDepState() {
		return depState;
	}
	public void setDepState(Boolean depState) {
		this.depState = depState;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
    
}
