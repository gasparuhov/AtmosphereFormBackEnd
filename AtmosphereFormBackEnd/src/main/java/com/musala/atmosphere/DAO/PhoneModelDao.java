package com.musala.atmosphere.DAO;

import java.util.HashMap;
import java.util.List;

import com.musala.atmosphere.models.PhoneModel;

public interface PhoneModelDao extends BaseDao<PhoneModel> {

	public List<PhoneModel> getByManufacturerId(int id);
	public List<PhoneModel> filter(HashMap<String, Object> filters);
}
