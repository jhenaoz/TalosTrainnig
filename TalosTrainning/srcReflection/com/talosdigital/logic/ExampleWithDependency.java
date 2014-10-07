package com.talosdigital.logic;

public class ExampleWithDependency {

	private Example examp;
	private int number;
	private long otherNumber;
	private String someText;
	private Integer someInteger;
	
	public ExampleWithDependency(){
		
	}

	public Example getExamp() {
		return examp;
	}

	public void setExamp(Example examp) {
		this.examp = examp;
	}

	public String getSomeText() {
		return someText;
	}

	public void setSomeText(String someText) {
		this.someText = someText;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public long getOtherNumber() {
		return otherNumber;
	}

	public void setOtherNumber(long otherNumber) {
		this.otherNumber = otherNumber;
	}

	public Integer getSomeInteger() {
		return someInteger;
	}

	public void setSomeInteger(Integer someInteger) {
		this.someInteger = someInteger;
	}
	
	
}
