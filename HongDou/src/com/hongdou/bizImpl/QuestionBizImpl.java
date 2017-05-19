package com.hongdou.bizImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hongdou.biz.QuestionBiz;
import com.hongdou.dao.QuestionDao;
import com.hongdou.pojo.Question;
import com.hongdou.utils.HongDouResult;

@Service("questionBiz")
public class QuestionBizImpl implements QuestionBiz{
	@Resource
	private QuestionDao questionDao;
	public void setQuestionDao(QuestionDao questionDao){
		this.questionDao = questionDao;
		
	}
	// 用户添加问题
	@Override
	public Question addQuestion(Question question) {
		return questionDao.addQuestion(question);
	}
	//根据id查看问题记录
	@Override
	public Question showQuestionById(int questionId) {
		Question question = questionDao.showQuestionById(questionId);
		return question;
	}
	

}
