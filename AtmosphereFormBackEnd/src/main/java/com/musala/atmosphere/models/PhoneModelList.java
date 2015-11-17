package com.musala.atmosphere.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "models")
public class PhoneModelList {

	private List<PhoneModel> models = new ArrayList<PhoneModel>();

	public List<PhoneModel> getModels() {
		return models;
	}

	@XmlElement(name = "model")
	public void setModels(List<PhoneModel> models) {
		this.models = models;
	}
}