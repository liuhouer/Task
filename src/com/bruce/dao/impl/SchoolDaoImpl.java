
package com.bruce.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.bruce.dao.SchoolDao;
import com.bruce.model.School;

@Service("SchoolDao")
public class SchoolDaoImpl extends HibernateDaoImpl<School, Serializable> implements SchoolDao {

}