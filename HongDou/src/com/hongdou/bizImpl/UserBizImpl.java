package com.hongdou.bizImpl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hongdou.biz.UserBiz;
import com.hongdou.dao.UserDao;
import com.hongdou.pojo.Users;
import com.hongdou.utils.HongDouResult;

@Service("userBiz")
public class UserBizImpl implements UserBiz {
	@Resource(name = "userDao")
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 用户登陆
	@Override

	public Users login(String username, String password) {
		// TODO Auto-generated method stub
		Users user = userDao.login(username, password);
		return user;
	}

	/**
	 * 修改密码
	 *//*
	public boolean changePassWord(String newPassWord, Integer userid) {
		userDao.changePassWord(newPassWord, userid);
		return true;
	}

	// 密码修改调用
	@Override
	public boolean comparePassWord(String oldPassWord, Integer userid) {
		return userDao.comparePassWord(oldPassWord, userid);
	}

	// 用户更改头像
	@Override
	public void updatePhoto(Users user, String file) {
		this.userDao.updatePhoto(user, file);
	}
*/
}
