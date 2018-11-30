package com.example.springproducer;

import javax.validation.constraints.Null;

public class TestPojo {
private  String firstName,lastName;

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}
}
