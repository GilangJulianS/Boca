package com.gilang.boca.main;

public class DataLapangan {

	int id;
	String name;
	String field;
	String address;
	
	public DataLapangan() {
		id = -1;
		name = "";
		address = "";
		field = "";
	}
	
	public DataLapangan(int id, String name, String field, String address){
		this.id = id;
		this.name = name;
		this.address = address;
		this.field = field;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
