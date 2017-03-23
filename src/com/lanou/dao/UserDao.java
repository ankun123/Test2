package com.lanou.dao;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lanou.entity.Item;
import com.lanou.entity.Score;
import com.lanou.entity.User;

public class UserDao {

	private HibernateTemplate template;

	public void addUser(User user) {

		template.save(user);
		System.out.println("UserDao:\t数据添加成功");
	}

	public List<User> findUser() {

		String hql = "from User";
		List<User> list = (List<User>) template.find(hql);
		System.out.println("UserDao:\t数据查询成功");

		return list;
	}

	public String updateUser(User user) {

		SessionFactory factory = template.getSessionFactory();
		Session session = factory.openSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session1 = request.getSession();
		String hql = "update User set userName=? ,passWord=?,idNumber=?,telno=? " + "where name=?";
		Query query = (session.createQuery(hql));
		query = query.setString(0, user.getUserName());
		query = query.setString(1, user.getPassWord());
		query = query.setString(2, user.getIdNumber());
		query = query.setString(3, user.getTelno());
		query = query.setString(4, (String) session1.getAttribute("name"));
		query.executeUpdate();
		return "updateSuccess";
	}

	public List<Item> findItem() {

		String hql = "from Item";
		List<Item> list = (List<Item>) template.find(hql);
		System.out.println("UserDao:\t数据查询Item成功");

		return list;
	}
	public List<Score> scoreList(){
		
//		SessionFactory factory = template.getSessionFactory();
//		Session session = factory.openSession();
//		HttpServletRequest request = ServletActionContext.getRequest();
//		HttpSession session1 = request.getSession();
//		
		String hql = "from Score ";
//		Query query = session.createQuery(hql);
//		query = query.setString(0, (String) session1.getAttribute("name"));		
		List<Score> list = (List<Score>) template.find(hql);
		
		return list ;
	}
	public List<Score> findScore(int id){
		List<Score> scores = (List<Score>) template.find("from Score where uId = " +id);
		return scores;
	}
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void addScore(Score score) {
		template.save(score);

	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

}
