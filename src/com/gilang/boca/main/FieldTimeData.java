package com.gilang.boca.main;

public class FieldTimeData {

	String fieldName;
	String fieldTag;
	String fieldTime;
	String fieldPrice;
	
	public FieldTimeData() {
		fieldName = "";
		fieldTag = "";
		fieldTime = "";
		fieldPrice = "";
	}
	
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldTag() {
		return fieldTag;
	}

	public void setFieldTag(String fieldTag) {
		this.fieldTag = fieldTag;
	}

	public String getFieldTime() {
		return fieldTime;
	}

	public void setFieldTime(String fieldTime) {
		this.fieldTime = fieldTime;
	}

	public String getFieldPrice() {
		return fieldPrice;
	}

	public void setFieldPrice(String fieldPrice) {
		this.fieldPrice = fieldPrice;
	}

	public FieldTimeData(String fieldName, String fieldTag, String fieldTime, String fieldPrice){
		this.fieldName = fieldName;
		this.fieldTag = fieldTag;
		this.fieldTime = fieldTime;
		this.fieldPrice = fieldPrice;
	}

}
