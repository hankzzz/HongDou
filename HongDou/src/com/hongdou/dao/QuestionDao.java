package com.hongdou.dao;


import java.util.List;

import com.hongdou.pojo.Question;

public interface QuestionDao {
	//用户添加问题
	public Question addQuestion(Question question);
	//根据id查看问题记录
	public Question showQuestionById(int questionId);
	//分页查询所有问题
	public List<Question> listOfQuestion(int offset,int pageSize);
	//查询所有问题记录数
	public int getAllrowCount();
	//根据关键字搜索问题
	public List<Question> findQuestionByKeyword(String keyword);

}
