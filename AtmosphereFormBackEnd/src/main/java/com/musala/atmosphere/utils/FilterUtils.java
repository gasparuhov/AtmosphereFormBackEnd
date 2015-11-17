package com.musala.atmosphere.utils;

import java.util.HashMap;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class FilterUtils {

	public static HashMap<String, Object> createFilterMap(String filterValue) {
		String[] pairs = null;
		filterValue = filterValue.replace('\"', ' ').trim();
		if (filterValue.indexOf("|") == -1) {
			pairs = new String[] { filterValue };
		} else {
			pairs = filterValue.split("\\|");
		}
		HashMap<String, Object> filters = new HashMap<String, Object>();
		for (String pair : pairs) {
			String[] filter = pair.split("::");
			if (filter.length < 2) {
				continue;
			}
			if (filter[0].indexOf("id") != -1) {
				filters.put(filter[0], Integer.parseInt(filter[1]));
			} else {
				filters.put(filter[0], filter[1]);
			}
		}
		return filters;
	}

	public static void fillCriteriaFilters(Criteria criteria,
			HashMap<String, Object> filters) {
		for (String key : filters.keySet()) {
			Object value = filters.get(key);
			if (value instanceof String) {
				criteria.add(Restrictions.like(key, "%" + value + "%"));
			}
			if (value instanceof Integer) {
				criteria.add(Restrictions.eq(key, value));
			}
		}
	}
}
