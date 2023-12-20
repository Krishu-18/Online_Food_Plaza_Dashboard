package com.project.service.impl;

import java.util.List;

import com.project.dao.UserDao;

import com.project.dao.impl.UserDaoImplUsingJdbc;
import com.project.dto.UserDTO;
import com.project.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImplUsingJdbc();
	// private UserDao userDao = new UserDaoImplUsingHibernate();

	@Override
	public boolean saveUser(UserDTO user) {
		System.out.println(user + " from user service impl layer");
		boolean isUserSaved = userDao.saveUser(user);
		return isUserSaved;
	}

	@Override
	public boolean updateUser(UserDTO user) {
		boolean isUserUpdate = userDao.updateUser(user);
		return isUserUpdate;
	}

	@Override
	public boolean deleteUser(String email) {

		return userDao.deleteUser(email);
	}

	@Override
	public UserDTO searchUser(UserDTO user) {
	    return userDao.searchUser(user);
	}

	@Override
	public List<UserDTO> showAllUser() {
		
		return userDao.showAllUser();
	}

}
