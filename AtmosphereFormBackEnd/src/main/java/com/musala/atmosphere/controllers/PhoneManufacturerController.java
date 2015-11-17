package com.musala.atmosphere.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musala.atmosphere.models.PhoneManufacturer;
import com.musala.atmosphere.models.PhoneManufacturerList;
import com.musala.atmosphere.services.PhoneManufacturerService;
import com.musala.atmosphere.utils.FilterUtils;

@RestController
public class PhoneManufacturerController {
	
	@Autowired(required = true)
	private PhoneManufacturerService service;

	@RequestMapping(value = "/manufacturers", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<PhoneManufacturerList> filterManufacturers(
			@RequestParam(required = false, value = "filter") String filterValue) {

		List<PhoneManufacturer> all = new ArrayList<PhoneManufacturer>();
		if (filterValue == null) {
			all = service.getAll();
		} else {
			HashMap<String, Object> filters = FilterUtils
					.createFilterMap(filterValue);

			all = service.filter(filters);
		}

		PhoneManufacturerList list = new PhoneManufacturerList();
		list.setManufacturers(all);

		return new ResponseEntity<PhoneManufacturerList>(list, HttpStatus.OK);
	}

}