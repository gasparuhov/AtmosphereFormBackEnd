package com.musala.atmosphere.services;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.atmosphere.DAO.PhoneManufacturerDao;
import com.musala.atmosphere.models.PhoneManufacturer;

@Service
public class PhoneManufacturerServiceImpl implements PhoneManufacturerService {

	@Autowired(required = true)
	private PhoneManufacturerDao dao;
	
	@Transactional
	public List<PhoneManufacturer> getAll() {
		return dao.getAll();
	}

	@Transactional
	public List<PhoneManufacturer> filter(HashMap<String, Object> filter) {
		return dao.filter(filter);
	}

	
}
