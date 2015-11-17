package com.musala.atmosphere.DAO;

import java.util.List;

import com.musala.atmosphere.models.PhoneModelNumber;
import com.musala.atmosphere.models.Report;

public interface ReportDao extends BaseDao<Report> {

	public List<PhoneModelNumber> getModelNumbersForAuthor(String author);
}
