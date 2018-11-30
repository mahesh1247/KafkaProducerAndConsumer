package com.example.springproducer;

public class DTOExample {
private String name,value;

public String getName() {
	return name;
}

@Override
public String toString() {
	return "DTOExample [name=" + name + ", value=" + value + "]";
}

public void setName(String name) {
	this.name = name;
}

public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
}

}
