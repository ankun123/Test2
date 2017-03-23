package com.lanou.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lanou.entity.Item;
import com.lanou.entity.User;


public class ItemDao {
	private HibernateTemplate tp;
	public void saveItem(Item item){
		tp.save(item);
	}
	public List<Item> find(){
		List<Item> items =(List<Item>) tp.find("from Item");
		return items;
	}
	public List<Item> findId (int qid){
		
		String hql = "from Item where qid="+qid;
		List<Item> items =  (List<Item>) tp.find(hql);
		return items;
	}
	
	
	
	public List<User> seeUser(){
		
		List<User> list = (List<User>) tp.find("from User");
		
		
		return list ;
	}
	
	
	
	
	public void delete(Item item){
		tp.delete(item);
	}
	
	public void update(Item item){
		tp.update(item);
	}
	
	public HibernateTemplate getTp() {
		return tp;
	}
	
	public void setTp(HibernateTemplate tp) {
		this.tp = tp;
	}
	
}
