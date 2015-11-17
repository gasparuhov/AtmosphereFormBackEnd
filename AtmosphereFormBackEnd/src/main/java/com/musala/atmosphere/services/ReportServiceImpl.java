package com.musala.atmosphere.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.musala.atmosphere.DAO.ReportDao;
import com.musala.atmosphere.models.PhoneModelNumber;
import com.musala.atmosphere.models.Report;
import com.musala.atmosphere.utils.ReportUtils;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired(required = true)
	private ReportDao dao;

	@Transactional
	public List<Report> getAll() {
		return dao.getAll();
	}

	@Transactional
	public Integer save(MultipartHttpServletRequest multipartRequest ) {
		ReportUtils utils = new ReportUtils(multipartRequest);
		Report report = utils.extractReport();
		if(report == null){
			return -1;
		}
		
		report.setVideoFile(utils.getFilePath());
		
		Integer result = dao.save(report);
		if(result == null || result < 0){
			return -1;
		}
		
		boolean save = utils.saveFile();
		
		if(!save){
			dao.delete(result);
			result = -1;
		}
		
		return result;
	}
	
	@Transactional
	public List<PhoneModelNumber> getModelNumbersForAuthor(String author){
		return dao.getModelNumbersForAuthor(author);
	}

}
