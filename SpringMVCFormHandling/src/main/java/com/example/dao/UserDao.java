package com.example.dao;

import java.util.List;

import com.example.model.User;

public interface UserDao {
	
	User findById(Integer id);
	List<User> findAllUser();
	void delete(Integer id);
	void save(User user);
	void update(User user);
}
