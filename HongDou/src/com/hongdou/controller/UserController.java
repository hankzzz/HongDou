package com.hongdou.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hongdou.biz.UserBiz;
import com.hongdou.pojo.Users;
import com.hongdou.utils.MD5;

@Controller("userContr")
@RequestMapping("/user")
public class UserController {
	@Resource
	UserBiz userBiz;
	@RequestMapping("/login")
	public String login(String username, String password, HttpSession httpSession) throws IOException {
		MD5 md = new MD5();// 调用md5加密，加密前端登录页面传过来的密码进行加密处理，与数据库中比较
		password = md.encryption(password);
		Users user = userBiz.login(username, password);
		if(user!=null){
			Users u = new Users();
			u.setId(user.getId());
			u.setName(user.getName());
			u.setPicture(user.getPicture());
			u.setSex(user.getSex());
			u.setStatus(user.getStatus());
			httpSession.setAttribute("user", u);
			return "index";
		}else{
			return "login";
		}
   }
}