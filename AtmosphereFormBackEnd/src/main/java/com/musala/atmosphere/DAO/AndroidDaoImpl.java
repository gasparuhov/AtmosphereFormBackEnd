package com.musala.atmosphere.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.musala.atmosphere.models.Android;

@Repository
public class AndroidDaoImpl implements AndroidDao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Override
	public Integer save(Android t) {
		Session session = sessionFactory.getCurrentSession();
		Integer result = (Integer) session.save(t);
		System.out.println("Record inserted sucessessfully");
		return result;
	}

	@Override
	public List<Integer> saveAll(ArrayList<Android> list) {
		Session session = sessionFactory.getCurrentSession();
		List<Integer> ids = new ArrayList<Integer>();
		for (Android obj : list) {
			ids.add((Integer) session.save(obj));
		}
		System.out.println("Records inserted sucessessfully");
		return ids;
	}

	@Override
	public void update(Android t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
		System.out.println("Record updated sucessessfully");
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();

		Android obj = findById(id);
		session.delete(obj);
		System.out.println("Record deleted sucessessfully");
	}

	@Override
	public Android findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Android obj = (Android) session.get(Android.class, id);
		return obj;
	}

	@Override
	public List<Android> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Android> list = session.createCriteria(Android.class).list();
		return list;
	}

}
