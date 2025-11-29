package com.turfNest.entity;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookedTurf {
	
@Id 
private int id;
private String name;
private LocalDate date;
private LocalTime time;
private int payment;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDate getDob() {
	return date;
}
public void setDob(LocalDate date) {
	this.date = date;
}
public LocalTime getLoginTime() {
	return time;
}
public void setLoginTime(LocalTime time) {
	this.time = time;
}
public int getPayment() {
	return payment;
}
public void setPayment(int payment) {
	this.payment = payment;
}
public BookedTurf(int id, String name, LocalDate dob, LocalTime loginTime, int payment) {
	super();
	this.id = id;
	this.name = name;
	this.date = dob;
	this.time = loginTime;
	this.payment = payment;
}
public BookedTurf() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "BookedTurf [id=" + id + ", name=" + name + ", dob=" + date + ", loginTime=" + time + ", payment="
			+ payment + "]";
}

}
