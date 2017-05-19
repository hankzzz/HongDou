package com.hongdou.biz;

import com.hongdou.pojo.Users;
import com.hongdou.utils.HongDouResult;

public interface UserBiz {
	// 用户登陆
	public Users login(String username, String password);
/*
	// 修改密码
	public boolean changePassWord(String newPassWord, Integer userid);

	// 密码修改调用
	public boolean comparePassWord(String oldPassWord, Integer userid);

	// 用户更改头像
	public void updatePhoto(Users user, String file);*/
}
