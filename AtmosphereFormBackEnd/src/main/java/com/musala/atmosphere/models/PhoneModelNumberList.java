package com.musala.atmosphere.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "numbers")
public class PhoneModelNumberList {
	
	private List<PhoneModelNumber> numbers = new ArrayList<PhoneModelNumber>();

	public List<PhoneModelNumber> getNumbers() {
		return numbers;
	}

	@XmlElement(name = "number")
	public void setNumbers(List<PhoneModelNumber> numbers) {
		this.numbers = numbers;
	}
}
