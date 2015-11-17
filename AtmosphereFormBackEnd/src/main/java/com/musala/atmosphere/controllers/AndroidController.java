package com.musala.atmosphere.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.musala.atmosphere.models.Android;
import com.musala.atmosphere.models.AndroidList;
import com.musala.atmosphere.services.AndroidService;

@RestController
public class AndroidController {

	@Autowired(required = true)
	private AndroidService service;

	@RequestMapping(value = "/androids", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<AndroidList> getAndroids() {

		AndroidList list = new AndroidList();
		list.setAndroids(service.getAll());

		return new ResponseEntity<AndroidList>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/androids", method = RequestMethod.POST)
	public ResponseEntity<String> saveAndroid(@RequestBody Android android) {
		service.save(android);
		System.out.println("android: " + android);
		return new ResponseEntity<String>("good", HttpStatus.CREATED);
	}

}
