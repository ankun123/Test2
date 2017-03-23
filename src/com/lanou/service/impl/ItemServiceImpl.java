package com.lanou.service.impl;

import java.util.List;

import com.lanou.dao.ItemDao;
import com.lanou.entity.Item;
import com.lanou.entity.User;
import com.lanou.service.ItemService;

public class ItemServiceImpl implements ItemService{

	private ItemDao itemdao;
	@Override
	public void add(Item item) {
		itemdao.saveItem(item);
	}


	@Override
	public List<Item> find() {
	   List<Item> items= itemdao.find();
	   return items;
	}

	@Override
	public void delete(Item item) {
		itemdao.delete(item);
	}

	@Override
	public void update(Item item) {
		itemdao.update(item);
	}


	@Override
	public List<Item> findId(int id) {
		List<Item> items = itemdao.findId(id);
		return items;
	}
	
	
	
	
	
	
	
	public ItemDao getItemdao() {
		return itemdao;
	}


	public void setItemdao(ItemDao itemdao) {
		this.itemdao = itemdao;
	}


	@Override
	public List<User> seeUser() {
		List<User> list = itemdao.seeUser();
		return list;
	}

}
