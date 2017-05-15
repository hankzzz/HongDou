package com.hongdou.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hongdou.biz.UserBiz;
import com.hongdou.pojo.Users;
import com.hongdou.utils.HongDouResult;
import com.hongdou.utils.MD5;

import net.coobird.thumbnailator.Thumbnails;
import net.sf.json.JSONArray;

@Controller("userContr")
@RequestMapping("/user")
public class UserController {
	@Resource
	UserBiz userBiz;

	@RequestMapping("/login")
	@ResponseBody
	public HongDouResult login(String username, String password, HttpSession httpSession) throws IOException {
		MD5 md = new MD5();// 调用md5加密，加密前端登录页面传过来的密码进行加密处理，与数据库中比较
		password = md.encryption(password);
		HongDouResult result = userBiz.login(username, password);
		if (result.getStatus()) {// 判断是否登录成功
			Users user = (Users) result.getObject();
			Users u = new Users();
			u.setName(user.getName());
			u.setPicture(user.getPicture());
			u.setSex(user.getSex());
			httpSession.setAttribute("user", u);
		}
		return result;
	}

	// 密码修改调用
	@RequestMapping("/comparePassWord")
	public String comparePassWord(Map<String, Object> model, HttpServletRequest request, String oldPassWord,
			String newPassWord, HttpSession httpSession) throws UnsupportedEncodingException {
		if (oldPassWord == newPassWord) {
			return "新旧密码不能一致！";
		} else {
			MD5 md5 = new MD5();
			oldPassWord = md5.encryption(oldPassWord);
			Users user = (Users) httpSession.getAttribute("user");
			Integer userid = user.getId();
			if (userBiz.comparePassWord(oldPassWord, userid)) {// 根据用户id和输入的旧密码查询数据库旧密码是否正确,返回boolean类型
				newPassWord = md5.encryption(newPassWord);
				userBiz.changePassWord(newPassWord, userid);
				model.put("wrong", "2");
				Enumeration<String> en = request.getSession().getAttributeNames();
				while (en.hasMoreElements()) {
					String object = en.nextElement().toString();
					try {
						request.getSession().removeAttribute(object);
					} catch (NoSuchElementException e) {
						return "userLogin";
					}
					// 使当前session失效
					// request.getSession().invalidate();
				}
				return "user/changePassword";
			} else {
				model.put("wrong", "1");
				return "user/changePassword";
			}
		}
	}

	// 修改头像
	@RequestMapping("/changePhoto")
	public ModelAndView uploadPhoto(MultipartFile filePhoto, HttpSession httpSession, HttpServletRequest request) {
		Users user = (Users) httpSession.getAttribute("user");
		ServletContext context = httpSession.getServletContext();
		// 第一级路径
		String firstPath = request.getSession().getServletContext().getRealPath("/") + "uploadFile";
		// 第二级路径
		String secondPath = firstPath + File.separator + "usersimgs" + File.separator;
		// String filePath =
		// request.getSession().getServletContext().getRealPath("/")+"uploadFile"+File.separator+"usersimgs"+File.separator;
		// 获取图片原始名称
		String originalFilename = filePhoto.getOriginalFilename();
		// 图片扩展名
		// String types =
		// originalFilename.substring(originalFilename.lastIndexOf(".") +
		// 1).toLowerCase();
		try {
			// 以用户id加图片扩展名给图片命名
			String newFileName = user.getId() + originalFilename.substring(originalFilename.lastIndexOf("."));
			// 完整路径
			String filePath = secondPath + newFileName;

			// 第一级路径
			File file1 = new File(firstPath);
			// 第二级路径
			File file2 = new File(secondPath);
			// 完整路径
			File file3 = new File(filePath);
			// 判断第二级路径是否存在
			if (!file2.exists()) {
				// 判断第一级路径是否存在
				if (!file1.exists()) {
					//
					file1.mkdir();
					file2.mkdir();
				}
			}
			// 上传
			filePhoto.transferTo(file3);
			// 以80*80大小改变图片
			Thumbnails.of(file3).size(80, 80).keepAspectRatio(false).toFile(file3);
			String password = userBiz.showUser(user.getId()).getPassword();
			user.setPassword(password);
			userBiz.updatePhoto(user, newFileName);
			context.setAttribute("photo", "photo");
			return new ModelAndView("/success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("changePhoto");
		}
	}

	// 注销登陆
	@RequestMapping("/exit")
	public String exit(HttpServletRequest request) {
		Enumeration<String> en = request.getSession().getAttributeNames();
		while (en.hasMoreElements()) {
			String object = en.nextElement().toString();
			try {
				request.getSession().removeAttribute(object);
			} catch (NoSuchElementException e) {
				return "userLogin";
			}
			// 使当前session失效
			// request.getSession().invalidate();
		}
		return "redirect:userLogin";
	}

}