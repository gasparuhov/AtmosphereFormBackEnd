package com.musala.atmosphere.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.musala.atmosphere.models.PhoneModelNumber;
import com.musala.atmosphere.utils.FilterUtils;

@Repository
public class PhoneModelNumberDaoImpl implements PhoneModelNumberDao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Override
	public List<PhoneModelNumber> getByModelId(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<PhoneModelNumber> list = session
				.getNamedQuery("getModelNumberByModelId")
				.setString("id", "" + id).list();

		return list;
	}

	@Override
	public List<PhoneModelNumber> filter(HashMap<String, Object> filters) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PhoneModelNumber.class);
		FilterUtils.fillCriteriaFilters(criteria, filters);
		List<PhoneModelNumber> list = criteria.list();

		return list;
	}

	@Override
	public List<Integer> saveAll(ArrayList<PhoneModelNumber> list) {
		Session session = sessionFactory.getCurrentSession();
		List<Integer> ids = new ArrayList<Integer>();
		for (PhoneModelNumber obj : list) {
			ids.add((Integer) session.save(obj));
		}
		System.out.println("Records inserted sucessessfully");
		return ids;
	}

	@Override
	public Integer save(PhoneModelNumber t) {
		Session session = sessionFactory.getCurrentSession();
		Integer result = (Integer) session.save(t);
		System.out.println("Record inserted sucessessfully");
		return result;
	}

	@Override
	public void update(PhoneModelNumber t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		System.out.println("Record updated sucessessfully");
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		PhoneModelNumber obj = findById(id);
		session.delete(obj);
		System.out.println("Record deleted sucessessfully");
	}

	@Override
	public PhoneModelNumber findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		PhoneModelNumber obj = (PhoneModelNumber) session.get(
				PhoneModelNumber.class, id);

		return obj;
	}

	@Override
	public List<PhoneModelNumber> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<PhoneModelNumber> list = session
				.createCriteria(PhoneModelNumber.class)
				.addOrder(Order.asc("name")).list();

		return list;
	}
}
