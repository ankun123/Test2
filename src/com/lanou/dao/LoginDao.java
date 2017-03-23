package com.lanou.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lanou.entity.Admin;


public class LoginDao {
	HibernateTemplate hibernateTemplate;
	public List<Admin> findAdmin(){
		String hql = "from Admin";
		List<Admin> admins = (List<Admin>) hibernateTemplate.find(hql);
		return admins;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
}
