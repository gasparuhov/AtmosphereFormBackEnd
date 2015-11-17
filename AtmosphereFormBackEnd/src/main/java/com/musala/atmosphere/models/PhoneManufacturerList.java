package com.musala.atmosphere.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "manufacturers")
public class PhoneManufacturerList {

	private List<PhoneManufacturer> manufacturers = new ArrayList<PhoneManufacturer>();

	public List<PhoneManufacturer> getManufacturers() {
		return manufacturers;
	}

	@XmlElement(name = "manufacturer")
	public void setManufacturers(List<PhoneManufacturer> manufacturers) {
		this.manufacturers = manufacturers;
	}
}