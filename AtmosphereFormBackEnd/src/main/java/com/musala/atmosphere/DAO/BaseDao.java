package com.musala.atmosphere.DAO;

import java.util.ArrayList;
import java.util.List;

public interface BaseDao<T> {
	public Integer save(T t);
	
	public List<Integer> saveAll(ArrayList<T> list);
	
	public void update(T t);

	public void delete(int id);

	public T findById(int id);

	public List<T> getAll();
}
