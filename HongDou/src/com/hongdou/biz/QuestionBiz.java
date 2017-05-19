package com.hongdou.biz;

import com.hongdou.pojo.Question;
import com.hongdou.utils.HongDouResult;

public interface QuestionBiz {
	// 用户添加问题
	public Question addQuestion(Question question);

	// 根据id查看问题记录
	public Question showQuestionById(int questionId);

}
