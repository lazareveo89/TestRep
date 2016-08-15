package com.test.secure.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends BaseModel implements Serializable{

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name="id")
 private Long id;
 
 @Column(unique = true, nullable = false)
 private String login;
 
 @Column(nullable = false)
 private String password;
 
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
}