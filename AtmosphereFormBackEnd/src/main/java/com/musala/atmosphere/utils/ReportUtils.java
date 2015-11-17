package com.musala.atmosphere.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musala.atmosphere.models.Report;

public class ReportUtils {

	private MultipartHttpServletRequest multipartRequest;
	private MultipartFile file = null;
	private boolean checked = false;

	public ReportUtils(MultipartHttpServletRequest multipartRequest) {
		this.multipartRequest = multipartRequest;
		loadFile();
	}

	private void loadFile() {
		if (checked) {
			return;
		}

		file = multipartRequest.getFile("file");
		checked = true;
	}

	public Report extractReport() {
		Report report = null;

		ObjectMapper mapper = new ObjectMapper();
		try {
			report = mapper.readValue(multipartRequest.getParameter("report"),
					Report.class);
			System.out.println(report);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return report;
	}

	public String getFilePath() {
		if (haveFile()) {
			return PropertiesParser.getVideoPath() + getFileName()
					+ getFileExtension();
		} else {
			return "";
		}
	}

	public boolean saveFile() {
		if (!haveFile()) {
			return true;
		}

		try {
			byte[] fileData = null;
			fileData = file.getBytes();
			FileOutputStream stream = new FileOutputStream(getFilePath());
			stream.write(fileData);
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	private String getFileExtension() {
		if (!haveFile()) {
			return "";
		}
		int index = file.getOriginalFilename().lastIndexOf(".");
		String fileExtension = file.getOriginalFilename().substring(index);
		return fileExtension;
	}

	private boolean haveFile() {
		if (file == null) {
			return false;
		} else {
			return true;
		}
	}

	private String getFileName() {

		Calendar now = Calendar.getInstance();
		long nameLong = now.getTimeInMillis();
		String fileName = Long.toString(nameLong);
		return fileName;

	}
}
