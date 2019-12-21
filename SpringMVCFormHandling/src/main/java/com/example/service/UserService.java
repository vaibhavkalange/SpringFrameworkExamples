package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {
	
	User findById(Integer id);
	List<User> findAllUser();
	void delete(Integer id);
	void saveOrUpdate(User user);

}
