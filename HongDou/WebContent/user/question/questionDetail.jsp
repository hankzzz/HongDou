<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>问题详细</title>
<link rel="shortcut icon" type="image/x-icon"
	href="http://192.168.0.168:8080/HongDou/images/favicon.ico"
	media="screen" />
</head>
<body>
	<span>${sessionScope.question.id}</span><br/> 
	<span>${sessionScope.question.title}</span><br/>
	<span>${sessionScope.question.content}</span><br/>
	<span>${sessionScope.question.publishtime}</span><br/>
	<span>${sessionScope.question.type}</span><br/>
	<span>${sessionScope.question.userid}</span><br/>
	<span>${sessionScope.question.pageview}</span><br/>
	<span>${sessionScope.question.commentcount}</span><br/>
	<span>${sessionScope.question.author}</span><br/>
	<span>${sessionScope.question.status}</span><br/>
</body>
</html>
