package com.gilang.boca.main;

public class DataSelectedField {
	
	int id;
	String field;
	String address;
	
	public DataSelectedField() {
		field = "";
		address = "";
		id = 0;
	}
	
	public DataSelectedField(int id, String field, String address){
		this.id = id;
		this.field = field;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
