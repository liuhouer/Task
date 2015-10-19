package com.bruce.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

@SuppressWarnings("hiding")
public interface HibernateDao<T, PK extends Serializable> {

	public <T extends Serializable> PK save(T entity);

	public <T extends Serializable> void update(T entity);

	public <T extends Serializable> void update(LinkedHashMap<String, T> update);

	public <T extends Serializable> void update(
			LinkedHashMap<String, T> update, String where, Object[] parameter);

	public <T extends Serializable> void delete(T entity);

	public void delete(PK... primaryKeyId);

	public void delete(String where, Object[] parameter);

	public T find(PK primarKeyId);

	public List<T> findAll();

}
