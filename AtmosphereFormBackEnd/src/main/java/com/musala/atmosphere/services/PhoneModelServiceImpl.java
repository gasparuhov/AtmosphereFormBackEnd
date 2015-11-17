package com.musala.atmosphere.services;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.atmosphere.DAO.PhoneModelDao;
import com.musala.atmosphere.models.PhoneModel;

@Service
public class PhoneModelServiceImpl implements PhoneModelService {

	@Autowired(required = true)
	private PhoneModelDao dao;

	@Transactional
	public List<PhoneModel> getAll() {
		return dao.getAll();
	}

	@Transactional
	public List<PhoneModel> filter(HashMap<String, Object> filter) {
		return dao.filter(filter);
	}

}
