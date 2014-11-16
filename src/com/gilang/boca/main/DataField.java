package com.gilang.boca.main;

public class DataField {
	
	int resId;
	String fieldName;
	int fieldImageResId;
	String fieldAddress;
	String fieldPhone;
	String fieldPrice;
	
	public DataField() {
		resId = 0;
		fieldName = "";
		fieldImageResId = 0;
		fieldAddress = "";
		fieldPhone = "";
		fieldPrice = "";
	}
	
	public DataField(int resId, String fieldName, int fieldImageResId, String fieldAddress, String fieldPhone, String fieldPrice) {
		this.fieldName = fieldName;
		this.fieldImageResId = fieldImageResId;
		this.fieldAddress = fieldAddress;
		this.fieldPhone = fieldPhone;
		this.fieldPrice = fieldPrice;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public int getFieldImageResId() {
		return fieldImageResId;
	}

	public void setFieldImageResId(int fieldImageResId) {
		this.fieldImageResId = fieldImageResId;
	}

	public String getFieldAddress() {
		return fieldAddress;
	}

	public void setFieldAddress(String fieldAddress) {
		this.fieldAddress = fieldAddress;
	}

	public String getFieldPhone() {
		return fieldPhone;
	}

	public void setFieldPhone(String fieldPhone) {
		this.fieldPhone = fieldPhone;
	}

	public String getFieldPrice() {
		return fieldPrice;
	}

	public void setFieldPrice(String fieldPrice) {
		this.fieldPrice = fieldPrice;
	}
}
