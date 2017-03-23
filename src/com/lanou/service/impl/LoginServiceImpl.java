package com.lanou.service.impl;

import java.util.List;

import com.lanou.dao.LoginDao;
import com.lanou.entity.Admin;
import com.lanou.service.LoginService;

public class LoginServiceImpl implements LoginService{


	 LoginDao loginDao;
	 
	 @Override
	 public String login(Admin admin) {
		List<Admin> as = loginDao.findAdmin();
		for (Admin admin2 : as) {
			if(admin2.getaName().equals(admin.getaName())&&
					admin2.getaPwd().equals(admin.getaPwd())){
				return "success";
			}
		}
		return "fail";
	}
	 
	public LoginDao getLoginDao() {
		return loginDao;
	}
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

}
