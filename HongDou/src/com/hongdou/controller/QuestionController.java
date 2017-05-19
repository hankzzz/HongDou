package com.hongdou.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hongdou.biz.QuestionBiz;
import com.hongdou.pojo.Question;
import com.hongdou.pojo.Users;
import com.hongdou.utils.HongDouResult;

@Controller("questionController")
@RequestMapping("/question")
public class QuestionController {
	@Resource
	QuestionBiz questionBiz;
	
	// 用户添加问题
	@RequestMapping("/addQuestion")
	public String  addQuestion(Question question ,HttpSession httpSession){
		Users user = (Users)httpSession.getAttribute("user");
		question.setUserid(user.getId());
		question = questionBiz.addQuestion(question);
		httpSession.setAttribute("question", question);
		return "user/bugdetail";
	}
	//根据id查看问题记录
	@RequestMapping("/showQuestionByTime")
	public String showQuestionByTime(HttpSession httpSession ){
		Users user = (Users)httpSession.getAttribute("user");
		Question question = questionBiz.showQuestionById(user.getId());
		httpSession.setAttribute("question", question);
	    return "user/bugdetail";
	}

}
