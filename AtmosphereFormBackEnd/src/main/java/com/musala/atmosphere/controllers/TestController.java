package com.musala.atmosphere.controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.MillisecondInstantPrinter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.musala.atmosphere.models.PhoneModelNumber;
import com.musala.atmosphere.models.PhoneModelNumberList;
import com.musala.atmosphere.services.ReportService;
import com.musala.atmosphere.utils.Constants;
import com.musala.atmosphere.utils.PropertiesParser;

@RestController
public class TestController {

	@Autowired(required = true)
	private ReportService service;

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public ResponseEntity<String> testFile(HttpServletRequest request) {
		
		System.out.println(request.getContentType());
		System.out.println(request instanceof MultipartHttpServletRequest);
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		System.out.println(multipartRequest.getMultipartContentType("file"));
		try {
			System.out.println(multipartRequest.getParameter("file").getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(multipartRequest.getParameter("file"));
		
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//		
//		
//		System.out.println(multipartRequest);
//
//		MultipartFile file = multipartRequest.getFile("file");	
//		try {
//			System.out.println("file: " + file.getBytes());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(multipartRequest.getParameter("file") != null);
////		System.out.println(multipartRequest.getParameter("file"));
//		
		

		FileOutputStream stream;
		try {
			byte[] b = multipartRequest.getParameter("file").getBytes("Cp1252");
			stream = new FileOutputStream("C:\\asd.jpg");
			stream.write(b);
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		
//		System.out.println("test: " + multipartRequest.getParameter("test"));

		return new ResponseEntity<String>("gg", HttpStatus.OK);
	}
}
