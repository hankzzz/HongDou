package com.hongdou.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hongdou.dao.UserDao;
import com.hongdou.pojo.Users;

@Repository("userDao") // (仓库)让spring扫描添加进bean
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Resource
	private SessionFactory sessionFactory;

	// @Resource(name="sessionFactory")
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	// 用户登陆
	public Users login(String username, String password) {

		Users user = (Users) sessionFactory.getCurrentSession()
				.createQuery("from Users u where u.name=:i and u.password=:p").setParameter("i", username)
				.setParameter("p", password).uniqueResult();
		return user;
	}
/*
	// 修改密码
	public boolean changePassWord(String newPassWord, Integer userid) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Users user = (Users) sessionFactory.getCurrentSession().createQuery("from Users where  id=:i")
				.setInteger("i", userid).uniqueResult();
		user.setPassword(newPassWord);
		session.update(session.merge(user));
		tr.commit();
		session.close();
		return true;

	}

	// 密码修改调用
	@Override
	public boolean comparePassWord(String oldPassWord, Integer userid) {
		Users user = (Users) sessionFactory.getCurrentSession().createQuery("from Users where password=:i and id=:k")
				.setParameter("i", oldPassWord).setInteger("k", userid).uniqueResult();
		if (user != null) {
			return true;
		} else {
			return false;
		}

	}

	// 用户修改头像
	@Override
	public void updatePhoto(Users user, String file) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		user.setPicture(file + "");
		session.update(session.merge(user));
		session.flush();
		tr.commit();
		session.close();
	}
*/
}
