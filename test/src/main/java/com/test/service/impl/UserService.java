package com.test.service.impl;

import com.test.dao.IUserDAO;
import com.test.dao.impl.UserDAO;
import com.test.model.UserModel;
import com.test.service.IUserService;

public class UserService implements IUserService {

	private IUserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}
	
}
