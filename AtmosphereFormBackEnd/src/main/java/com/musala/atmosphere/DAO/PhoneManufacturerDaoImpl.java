package com.musala.atmosphere.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.musala.atmosphere.models.PhoneManufacturer;
import com.musala.atmosphere.utils.FilterUtils;

@Repository
public class PhoneManufacturerDaoImpl implements PhoneManufacturerDao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Override
	public Integer save(PhoneManufacturer t) {
		Session session = sessionFactory.getCurrentSession();
		Integer result = (Integer) session.save(t);
		System.out.println("Record inserted sucessessfully");
		return result;
	}

	@Override
	public List<Integer> saveAll(ArrayList<PhoneManufacturer> list) {
		Session session = sessionFactory.getCurrentSession();
		List<Integer> ids = new ArrayList<Integer>();
		for (PhoneManufacturer obj : list) {
			ids.add((Integer) session.save(obj));
		}
		System.out.println("Records inserted sucessessfully");
		return ids;
	}

	@Override
	public void update(PhoneManufacturer t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		System.out.println("Record updated sucessessfully");
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		PhoneManufacturer obj = findById(id);
		session.delete(obj);
		System.out.println("Record deleted sucessessfully");
	}

	@Override
	public PhoneManufacturer findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		PhoneManufacturer obj = (PhoneManufacturer) session.get(
				PhoneManufacturer.class, id);

		return obj;
	}

	@Override
	public List<PhoneManufacturer> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<PhoneManufacturer> list = session
				.createCriteria(PhoneManufacturer.class)
				.addOrder(Order.asc("name")).list();

		return list;
	}

	@Override
	public List<PhoneManufacturer> filter(HashMap<String, Object> filters) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PhoneManufacturer.class);
		FilterUtils.fillCriteriaFilters(criteria, filters);
		List<PhoneManufacturer> list = criteria.list();

		return list;
	}

}
