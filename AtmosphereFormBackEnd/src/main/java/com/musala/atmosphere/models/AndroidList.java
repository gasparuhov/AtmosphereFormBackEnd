package com.musala.atmosphere.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "androids")
public class AndroidList {

	
	private List<Android> androids = new ArrayList<Android>();

	@XmlElement(name = "android")
	public List<Android> getAndroids() {
		return androids;
	}

	public void setAndroids(List<Android> androids) {
		this.androids = androids;
	}
}
