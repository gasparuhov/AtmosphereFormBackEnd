package com.musala.atmosphere.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.musala.atmosphere.models.PhoneModel;
import com.musala.atmosphere.models.PhoneModelList;
import com.musala.atmosphere.services.PhoneModelService;
import com.musala.atmosphere.utils.FilterUtils;

@RestController
public class PhoneModelController {
	
	@Autowired(required = true)
	private PhoneModelService service;

	@RequestMapping(value = "/models", method = RequestMethod.GET)
	public ResponseEntity<PhoneModelList> filterModelNumbers(
			@RequestParam(required = false, value = "filter") String filterValue) {

		ArrayList<PhoneModel> all = new ArrayList<PhoneModel>();
		if (filterValue == null) {
			all = (ArrayList<PhoneModel>) service.getAll();
		} else {
			HashMap<String, Object> filters = FilterUtils
					.createFilterMap(filterValue);

			all = (ArrayList<PhoneModel>) service.filter(filters);
		}

		PhoneModelList list = new PhoneModelList();
		list.setModels(all);

		return new ResponseEntity<PhoneModelList>(list, HttpStatus.OK);
	}
}
