package com.hongdou.biz;


import com.hongdou.pojo.Question;
import com.hongdou.pojo.Page;

public interface QuestionBiz {
	// 用户添加问题
	public Question addQuestion(Question question);

	// 根据id查看问题记录
	public Question showQuestionById(int questionId);
	
	//查询所有问题
	public Page listOfQuestion(int currentPage,int pageSize);
	

}
