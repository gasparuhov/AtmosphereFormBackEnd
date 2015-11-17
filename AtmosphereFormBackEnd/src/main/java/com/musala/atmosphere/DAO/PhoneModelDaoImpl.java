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

import com.musala.atmosphere.models.PhoneModel;
import com.musala.atmosphere.models.PhoneModelNumber;
import com.musala.atmosphere.utils.FilterUtils;

@Repository
public class PhoneModelDaoImpl implements PhoneModelDao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Override
	public List<PhoneModel> getByManufacturerId(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<PhoneModel> list = session
				.getNamedQuery("getModelByManufacturerId")
				.setString("id", "" + id).list();
		return list;
	}

	public List<PhoneModel> filter(HashMap<String, Object> filters) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PhoneModel.class);
		FilterUtils.fillCriteriaFilters(criteria, filters);
		List<PhoneModel> list = criteria.list();

		return list;
	}

	@Override
	public Integer save(PhoneModel t) {
		Session session = sessionFactory.getCurrentSession();
		Integer result = (Integer) session.save(t);
		System.out.println("Record inserted sucessessfully");
		return result;
	}

	@Override
	public List<Integer> saveAll(ArrayList<PhoneModel> list) {
		Session session = sessionFactory.getCurrentSession();
		List<Integer> ids = new ArrayList<Integer>();
		for (PhoneModel obj : list) {
			ids.add((Integer) session.save(obj));
		}
		System.out.println("Records inserted sucessessfully");
		return ids;
	}

	@Override
	public void update(PhoneModel t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		System.out.println("Record updated sucessessfully");
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		PhoneModel obj = findById(id);
		session.delete(obj);
		System.out.println("Record deleted sucessessfully");
	}

	@Override
	public PhoneModel findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		PhoneModel obj = (PhoneModel) session.get(PhoneModel.class, id);

		return obj;
	}

	@Override
	public List<PhoneModel> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<PhoneModel> list = session.createCriteria(PhoneModel.class)
				.addOrder(Order.asc("name")).list();

		return list;
	}
}
