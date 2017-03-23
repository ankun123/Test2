package com.lanou.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;

import com.lanou.entity.Admin;
import com.lanou.entity.Item;
import com.lanou.entity.User;
import com.lanou.service.ItemService;
import com.lanou.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Item item;
	private Admin admin;

	private ItemService itemService;
	private LoginService loginService;

	public String login() {
		String str = loginService.login(admin);
		if(str.equals("success")){
			HttpServletRequest req = ServletActionContext.getRequest();
			HttpSession session = req.getSession();
			session.setAttribute("admin", admin);
			
			
		}
		return str;
	}
	public String zhijie(){
		List<Item> items = itemService.find();
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("items", items);
		return "ok";
	}
	
	
	public String adminExit(){
		
		
		
		
		return "adminExitSuccess";
	}
	
	
	public String add() {
		if (item != null) {
			itemService.add(item);
			List<Item> items = itemService.find();
			HttpServletRequest req = ServletActionContext.getRequest();
			req.setAttribute("items", items);
			return "ok";
		}
		return "no";
	}

	public String dispItem() {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Item> items = itemService.findId(Integer.parseInt(req.getParameter("id")));
		if (items != null) {
			req.setAttribute("itemsA", items);
			return "modifyItem";
		}
		return "no";
	}

	public String deleteItem() {
		HttpServletRequest req = ServletActionContext.getRequest();
		List<Item> items = itemService.findId(Integer.parseInt(req.getParameter("id")));
		if (items != null) {
			for (Item item : items) {
				itemService.delete(item);
				return "shan";
			}
		}
		return "no";
	}

	
	
	public String seeUser(){
		
		List<User> list = itemService.seeUser();
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("seeUser", list);
		
		return "seeUserSuccess";
	}
	
	
	
	
	
	
	
	
	public String update() {
		if (item != null) {
			itemService.update(item);
			return "gai";
		}
		return "no";
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}
