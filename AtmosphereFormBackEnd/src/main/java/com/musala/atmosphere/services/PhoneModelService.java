package com.musala.atmosphere.services;

import java.util.HashMap;
import java.util.List;

import com.musala.atmosphere.models.PhoneModel;

public interface PhoneModelService {

	public List<PhoneModel> getAll();
	public List<PhoneModel> filter(HashMap<String, Object> filter);
}
