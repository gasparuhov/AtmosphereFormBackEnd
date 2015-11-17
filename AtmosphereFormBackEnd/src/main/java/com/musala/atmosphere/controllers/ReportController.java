package com.musala.atmosphere.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.musala.atmosphere.models.PhoneModelNumber;
import com.musala.atmosphere.models.PhoneModelNumberList;
import com.musala.atmosphere.models.Report;
import com.musala.atmosphere.models.ReportList;
import com.musala.atmosphere.services.ReportService;
import com.musala.atmosphere.utils.Constants;

@RestController
public class ReportController {

	@Autowired(required = true)
	private ReportService service;

	@RequestMapping(value = "/reports", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ReportList> getReports() {

		List<Report> all = service.getAll();

		ReportList list = new ReportList();
		list.setReports(all);

		return new ResponseEntity<ReportList>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/reports", method = RequestMethod.POST)
	public ResponseEntity<String> saveReport(HttpServletRequest request) {

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		Integer result = service.save(multipartRequest);

		if (result < 0) {
			return new ResponseEntity<String>(Constants.BAD_REPORT_SUBMIT,
					HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>(Constants.SUCCESS_REPORT_SUBMIT,
				HttpStatus.OK);
	}

	@RequestMapping(value = "/reports/modelNumbers", method = RequestMethod.GET)
	public ResponseEntity<PhoneModelNumberList> getModelNumbersFromReports(
			@RequestParam(required = true, value = "author") String author) {

		List<PhoneModelNumber> modelNumbers = service
				.getModelNumbersForAuthor(author);

		PhoneModelNumberList all = new PhoneModelNumberList();
		all.setNumbers(modelNumbers);

		return new ResponseEntity<PhoneModelNumberList>(all, HttpStatus.OK);
	}

}
