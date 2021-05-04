package com.test.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.test.dao.ICategoryDAO;
import com.test.model.CategoryModel;
import com.test.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
}
