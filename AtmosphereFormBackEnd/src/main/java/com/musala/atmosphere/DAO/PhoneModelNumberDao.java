package com.musala.atmosphere.DAO;

import java.util.HashMap;
import java.util.List;

import com.musala.atmosphere.models.PhoneModelNumber;

public interface PhoneModelNumberDao extends BaseDao<PhoneModelNumber> {

	public List<PhoneModelNumber> getByModelId(int id);
	public List<PhoneModelNumber> filter(HashMap<String, Object> filters);
}
