package com.hongdou.bizImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hongdou.biz.QuestionBiz;
import com.hongdou.dao.QuestionDao;
import com.hongdou.pojo.Page;
import com.hongdou.pojo.Question;
import com.hongdou.utils.HongDouResult;

@Service("questionBiz")
public class QuestionBizImpl implements QuestionBiz {
	@Resource
	private QuestionDao questionDao;

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;

	}

	// 用户添加问题
	@Override
	public Question addQuestion(Question question) {
		return questionDao.addQuestion(question);
	}

	// 根据id查看问题记录
	@Override
	public Question showQuestionById(int questionId) {
		Question question = questionDao.showQuestionById(questionId);
		return question;
	}

	// 查询所有问题
	@Override
	public Page listOfQuestion(int currentPage, int pageSize) {
		Page page = new Page();
		// 总记录数
		int allRow = questionDao.getAllrowCount();
		// 当前页开始记录
		int offset = page.countOffset(currentPage, pageSize);
		// 分页查询结果集
		List<Question> list = questionDao.listOfQuestion(offset, pageSize);
		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);
		return page;
	}

	// 根据关键字搜索问题
	@Override
	public List<Question> findQuestionByKeyword(String keyword) {
		List<Question> list = questionDao.findQuestionByKeyword(keyword);
		return list;
	}

}
