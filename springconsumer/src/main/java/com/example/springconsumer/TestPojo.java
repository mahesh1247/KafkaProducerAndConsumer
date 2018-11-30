package com.example.springconsumer;

import javax.validation.constraints.Null;

public class TestPojo {
private  String firstName;
private  String lastName = null;
@Null
private int age =0;


public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}
}
