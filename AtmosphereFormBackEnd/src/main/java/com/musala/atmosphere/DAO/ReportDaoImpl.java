package com.musala.atmosphere.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.musala.atmosphere.models.PhoneModelNumber;
import com.musala.atmosphere.models.Report;

@Repository
public class ReportDaoImpl implements ReportDao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Override
	public Integer save(Report t) {
		Session session = sessionFactory.getCurrentSession();
		Integer result = (Integer) session.save(t);
		System.out.println("Record inserted sucessessfully");
		return result;
	}

	@Override
	public List<Integer> saveAll(ArrayList<Report> list) {
		Session session = sessionFactory.getCurrentSession();
		List<Integer> ids = new ArrayList<Integer>();
		for (Report obj : list) {
			ids.add((Integer) session.save(obj));
		}
		System.out.println("Records inserted sucessessfully");
		return ids;
	}

	@Override
	public void update(Report t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		System.out.println("Record updated sucessessfully");
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Report obj = findById(id);
		session.delete(obj);
		System.out.println("Record deleted sucessessfully");
	}

	@Override
	public Report findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Report obj = (Report) session.get(Report.class, id);

		return obj;
	}

	@Override
	public List<Report> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Report> list = session.createCriteria(Report.class).list();

		return list;
	}
	
	@Override
	public List<PhoneModelNumber> getModelNumbersForAuthor(String author){
		Session session = sessionFactory.getCurrentSession();
		List<PhoneModelNumber> list = session
				.getNamedQuery("getUsedModelNumbers")
				.setString("author", author).list();

		return list;
	}
}
