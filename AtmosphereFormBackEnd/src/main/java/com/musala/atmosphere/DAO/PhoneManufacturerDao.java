package com.musala.atmosphere.DAO;

import java.util.HashMap;
import java.util.List;

import com.musala.atmosphere.models.PhoneManufacturer;

public interface PhoneManufacturerDao extends BaseDao<PhoneManufacturer> {
	
	public List<PhoneManufacturer> filter(HashMap<String, Object> filters);

}
