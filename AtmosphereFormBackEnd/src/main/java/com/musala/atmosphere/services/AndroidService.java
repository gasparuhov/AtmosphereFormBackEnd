package com.musala.atmosphere.services;

import java.util.List;

import com.musala.atmosphere.models.Android;

public interface AndroidService {
	
	public List<Android> getAll();
	public Integer save(Android android);
}
