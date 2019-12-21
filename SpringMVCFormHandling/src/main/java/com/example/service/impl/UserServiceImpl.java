package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User findById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public void saveOrUpdate(User user) {
		
		if(findById(user.getId())==null){
			userDao.save(user);
		}
		else{
			userDao.update(user);
		}
	}

}
