package com.musala.atmosphere.services;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.atmosphere.DAO.PhoneModelNumberDao;
import com.musala.atmosphere.models.PhoneModelNumber;

@Service
public class PhoneModelNumberServiceImpl implements PhoneModelNumberService {
	
	@Autowired(required = true)
	private PhoneModelNumberDao dao;

	@Transactional
	public List<PhoneModelNumber> getAll() {
		return dao.getAll();
	}

	@Transactional
	public List<PhoneModelNumber> filter(HashMap<String, Object> filter) {
		return dao.filter(filter);
	}

}
