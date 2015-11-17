package com.musala.atmosphere.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.musala.atmosphere.models.PhoneModelNumber;
import com.musala.atmosphere.models.PhoneModelNumberList;
import com.musala.atmosphere.services.PhoneModelNumberService;
import com.musala.atmosphere.utils.FilterUtils;

@RestController
public class PhoneModelNumberController {
	
	@Autowired(required = true)
	private PhoneModelNumberService service;

	@RequestMapping(value = "/modelNumbers", method = RequestMethod.GET)
	public ResponseEntity<PhoneModelNumberList> filterModelNumbers(
			@RequestParam(required = false, value = "filter") String filterValue) {

		List<PhoneModelNumber> all = new ArrayList<PhoneModelNumber>();
		if (filterValue == null) {
			all = service.getAll();
		} else {
			HashMap<String, Object> filters = FilterUtils
					.createFilterMap(filterValue);

			all = service.filter(filters);
		}

		PhoneModelNumberList list = new PhoneModelNumberList();
		list.setNumbers(all);

		return new ResponseEntity<PhoneModelNumberList>(list, HttpStatus.OK);
	}
}
