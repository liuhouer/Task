package com.bruce.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruce.dao.SchoolDao;
import com.bruce.manager.SchoolManager;
import com.bruce.model.School;

@Service("SchoolManager")
public class SchoolManagerImpl implements SchoolManager {

	@Autowired
	private SchoolDao SchoolDao;



	@Override
	public void addSchool(School School) {
		SchoolDao.save(School);
	}

}
