package com.app.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employewithrole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public String getSecond_name() {
		return second_name;
	}
	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}
	private String first_name;
	private String second_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String email;
}
