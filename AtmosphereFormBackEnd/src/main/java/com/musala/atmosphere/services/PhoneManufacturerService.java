package com.musala.atmosphere.services;

import java.util.HashMap;
import java.util.List;

import com.musala.atmosphere.models.PhoneManufacturer;

public interface PhoneManufacturerService {

	public List<PhoneManufacturer> getAll();
	public List<PhoneManufacturer> filter(HashMap<String, Object> filter);
}
