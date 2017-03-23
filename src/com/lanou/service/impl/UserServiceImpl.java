package com.lanou.service.impl;

import java.util.List;

import com.lanou.dao.UserDao;
import com.lanou.entity.Item;
import com.lanou.entity.Score;
import com.lanou.entity.User;
import com.lanou.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Override
	public void addUser(User user) {

		userDao.addUser(user);

		System.out.println("UserServiceImpl:\t传递user完成");
	}

	@Override
	public List<User> findUser() {

		List<User> list = userDao.findUser();

		return list;
	}

	@Override
	public String update(User user) {
		
		String aa = userDao.updateUser(user);

		return aa ;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<Item> findItem() {
		List<Item> list = userDao.findItem();
		
		
		return list;
	}

	@Override
	public void addScore(Score score) {
		
		userDao.addScore(score);
		
	}
	@Override
	public List<Score> seeScore() {
		
		 List<Score> list = userDao.scoreList();
		
		return list;
	}

	@Override
	public List<Score> findScore(int id) {
		List<Score> scores = userDao.findScore(id);
		return scores;
	}

}
