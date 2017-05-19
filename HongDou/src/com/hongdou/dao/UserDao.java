package com.hongdou.dao;

import com.hongdou.pojo.Users;

public interface UserDao {
	// 用户登陆
	public Users login(String username, String password);

	/*// 修改密码
	public boolean changePassWord(String newPassWord, Integer userid);

	// 密码修改调用
	public boolean comparePassWord(String oldPassWord, Integer userid);

	// 用户修改头像
	public void updatePhoto(Users user, String file);*/
}
