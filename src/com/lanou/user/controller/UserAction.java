package com.lanou.user.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.lanou.dao.UserDao;
import com.lanou.entity.Item;
import com.lanou.entity.Score;
import com.lanou.entity.User;
import com.lanou.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2826765823483246464L;

	private User user;
	private Item item;
	private UserService userService;
//	private HibernateTemplate template;

	public String register() {

		if (!user.getName().equals("") && !user.getIdNumber().equals("") && !user.getPassWord().equals("")
				&& !user.getTelno().equals("") && !user.getUserName().equals("")) {

			System.out.println("UserAction:\t" + user.getName());
			userService.addUser(user);
			return "registerSuccess";
		}
		return "registerFail";
	}

	public String login() {
		List<User> list = userService.findUser();

		for (User u : list) {
			if (user.getUserName().equals(u.getUserName()) && user.getPassWord().equals(u.getPassWord())) {

				System.out.println("UserAction:\t" + user.getUserName());
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("id", u.getuId());
				session.setAttribute("name", u.getName());
				session.setAttribute("password", u.getPassWord());
				session.setAttribute("idNumber", u.getIdNumber());
				session.setAttribute("userName", u.getUserName());
				session.setAttribute("telno", u.getTelno());

				session.setAttribute("saishen", u);
				return "loginSuccess";
			}
		}
		return "loginFail";
	}
	public String go(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int id =(int) session.getAttribute("id");
		List<Score> scores= userService.findScore(id);
		request.setAttribute("scores", scores);
		return "goSuccess";
	}
	public String update() {

		if (!user.getPassWord().equals(null)) {
			String aa = userService.update(user);
			if (aa != null) {
				return aa;
			}
		}
		return "updateFail";
	}

	public String exit() {

		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();

		session.clear();
		return "exitSuccess";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
	}

	public String findItem() {

		List<Item> list = userService.findItem();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("item", list);

		return "findItemSuccess";
	}

	public String upAnswer() {

		int i;
		int f = 0;
		HttpServletRequest req = ServletActionContext.getRequest();
		// System.out.println(item.getAnswer());

		for (i = 1; i > 0; i++) {
			if (req.getParameter("daan" + i) != null && req.getParameter("daan" + i).length() != 0) {
				String b = req.getParameter(String.valueOf(i));
				String a = req.getParameter("daan" + i);
				if (a.equals(b)) {
					f++;
				}
			} else {
				break;
			}
		}

		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("saishen");

		Score score = new Score();
		score.setuId(user.getuId());
		score.setName(user.getName());
		score.setScore(f);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间
		score.setDate(date);
		userService.addScore(score);
		System.out.println(f);
		request.setAttribute("thisAnswer", score);
		return "upAnswerSuccess";
	}
	public String seeScore() {

		List<Score> list = userService.seeScore();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("seeScore", list);

		return "seeScoreSuccess";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
