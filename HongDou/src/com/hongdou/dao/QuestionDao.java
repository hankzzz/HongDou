package com.hongdou.dao;


import java.util.List;

import com.hongdou.pojo.Question;

public interface QuestionDao {
	//用户添加问题
	public Question addQuestion(Question question);
	//根据id查看问题记录
	public Question showQuestionById(int questionId);
	//查询所有问题
	public List<Question> listOfQuestion();

}
