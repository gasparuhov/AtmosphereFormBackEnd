package com.musala.atmosphere.services;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.musala.atmosphere.models.PhoneModelNumber;
import com.musala.atmosphere.models.Report;

public interface ReportService {

	public List<Report> getAll();
	public Integer save(MultipartHttpServletRequest multipartRequest );
	public List<PhoneModelNumber> getModelNumbersForAuthor(String author);
}
