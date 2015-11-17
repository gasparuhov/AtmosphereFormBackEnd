package com.musala.atmosphere.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.atmosphere.DAO.AndroidDao;
import com.musala.atmosphere.models.Android;

@Service
public class AndroidServiceImpl implements AndroidService {

	@Autowired(required = true)
	private AndroidDao dao;
	
	@Transactional
	public List<Android> getAll() {
		return this.dao.getAll();
	}

	@Transactional
	public Integer save(Android android) {
		return this.dao.save(android);
	}

}
