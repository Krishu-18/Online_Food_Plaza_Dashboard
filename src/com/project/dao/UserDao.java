package com.project.dao;

import java.util.List;

import com.project.dto.UserDTO;

public interface UserDao {

	boolean saveUser(UserDTO user);
	boolean updateUser(UserDTO user);
	boolean deleteUser(String email);
	UserDTO searchUser(UserDTO user);
	List<UserDTO> showAllUser();
	
}
