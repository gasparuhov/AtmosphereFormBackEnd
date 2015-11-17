package com.musala.atmosphere.services;

import java.util.HashMap;
import java.util.List;

import com.musala.atmosphere.models.PhoneModelNumber;

public interface PhoneModelNumberService {

	public List<PhoneModelNumber> getAll();
	public List<PhoneModelNumber> filter(HashMap<String, Object> filter);
}
