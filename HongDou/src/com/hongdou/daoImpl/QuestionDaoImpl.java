package com.hongdou.daoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hongdou.dao.QuestionDao;
import com.hongdou.pojo.Question;

@Repository("questionDao")
public class QuestionDaoImpl extends HibernateDaoSupport implements QuestionDao {
	@Resource
	private SessionFactory sessionFactory;

	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	// 用户添加问题
	@Override
	public Question addQuestion(Question question) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Date date = new Date();
			question.setCommentcount(0);// 设置评论数量为0
			question.setPageview(0);// 设置浏览量为0
			question.setPublishtime(date);
			question.setStatus(0);// 设置默认状态为0
			session.save(question);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return question;
	}

	// 根据id查看问题记录
	@Override
	public Question showQuestionById(int questionId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Question t  where t.id = " + questionId;
		Question question = (Question) session.createQuery(hql).uniqueResult();
		return question;
	}

	// 查询所有问题
	@Override
	public List<Question> listOfQuestion(int offset, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Question t where t.status=0");
		query.setFirstResult(offset);
		query.setMaxResults(pageSize);
		return query.list();
	}

	// 查询所有问题记录数
	@Override
	public int getAllrowCount() {
		Long count = (Long) sessionFactory.getCurrentSession()
				.createQuery("select count(*) from Question q where q.status=0 ").uniqueResult();
		return count.intValue();
	}
	// 根据关键字搜索问题

	@Override
	public List<Question> findQuestionByKeyword(String keyword) {

		List<Question> list = sessionFactory.getCurrentSession()
				.createQuery("from Question q where instr(lower(q.title),'" + keyword
						+ "')>0 and q.status=0  or instr(lower(q.content),'" + keyword
						+ "')>0 and q.status=0 order by q.pageview desc")
				.list();// 默认按浏览量排序
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setTitle(
						list.get(i).getTitle().replaceAll(keyword, "<font color='red'>" + keyword + "</font>"));
				list.get(i).setContent(
						list.get(i).getContent().replaceAll(keyword, "<font color='red'>" + keyword + "</font>"));
			}

		}
		return list;

	}

}
