package com.lanou.service;

import java.util.List;

import com.lanou.entity.Item;
import com.lanou.entity.Score;
import com.lanou.entity.User;

public interface UserService {

	
	public void addUser(User user);
	
	public List<User> findUser();
	
	public String update(User user);
	
	public List<Item> findItem();
	
	public void addScore(Score score);
	public List<Score> seeScore();
	public List<Score> findScore(int id);
}
