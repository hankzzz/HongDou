package com.hongdou.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hongdou.biz.QuestionBiz;
import com.hongdou.pojo.Page;
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
	public String addQuestion(Question question, HttpSession httpSession) {
		Users user = (Users) httpSession.getAttribute("user");
		question.setUserid(user.getId());
		question = questionBiz.addQuestion(question);
		httpSession.setAttribute("question", question);
		return "user/bugdetail";
	}

	// 根据id查看问题记录
	@RequestMapping("/showQuestionByTime")
	public String showQuestionByTime(HttpSession httpSession, int questionId) {
		Question question = questionBiz.showQuestionById(questionId);
		httpSession.setAttribute("question", question);
		return "user/question/questionDetail";
	}

	// 查询所有问题
	@RequestMapping("/listOfQuestion")
	public String listOfQuestion(Map<String, Object> model, String pageNo) {
		List<Question> list = new ArrayList<Question>();
		// List<Question> list = questionBiz.listOfQuestion();
		// 定义Page类
		Page page;
		// pageNo是前台传过来的当前页，如果是第一次，默认显示第一页
		if (pageNo == null) {
			pageNo = "1";
		}
		// 根据当前页，每次查询10条
		page = questionBiz.listOfQuestion(Integer.valueOf(pageNo), 2);
		list.addAll(page.getList());
		model.put("page", page);
		model.put("list", list);
		return "user/question/listOfQuestion";
	}

	// 根据关键字搜索问题
	@RequestMapping("/findQuestionByKeyword")
	public String findQuestionByKeyword(Map<String, Object> model, String keyword) {
		if (keyword != null) {
			List<Question> list = questionBiz.findQuestionByKeyword(keyword);
			model.put("list", list);
			return "user/question/findResultByKeyWord";
		} else {
			return "";
		}

	}

}
