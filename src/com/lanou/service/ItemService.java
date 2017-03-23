package com.lanou.service;

import java.util.List;

import com.lanou.entity.Item;
import com.lanou.entity.User;


public interface ItemService {
	public void add(Item item);

	public List<Item> find();

	public void delete(Item item);

	public void update(Item item);
	public List<Item> findId(int id);
	public List<User> seeUser();
}