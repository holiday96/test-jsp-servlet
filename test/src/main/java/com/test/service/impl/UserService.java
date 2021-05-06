package com.test.service.impl;

import javax.inject.Inject;

import com.test.dao.IUserDAO;
import com.test.model.UserModel;
import com.test.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}
	
}
