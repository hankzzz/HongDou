<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>红豆</title>
<link rel="shortcut icon" type="image/x-icon"
	href="http://192.168.0.168:8080/HongDou/images/favicon.ico"
	media="screen" />
</head>
<body>
	<span>当前用户:</span>${sessionScope.user.name}<br />
	<span>账户状态:</span>
	<c:choose>
		<c:when test="${sessionScope.user.status==0}">正常</c:when>
		<c:otherwise>ee</c:otherwise>
	</c:choose>
	<br />
	<span>可用操作： <a
		href="${pageContext.request.contextPath}/question/listOfQuestion">查看bug记录</a><br />
		<a href="${pageContext.request.contextPath}/user/index.html">添加bug记录</a>
	</span>
	<div>
		<form
			action="${pageContext.request.contextPath}/question/findQuestionByKeyword"
			method="post">
			<input type="text" value="" name="keyword"> 
			<input type="submit" value="提交查询">
		</form>
	</div>
</body>
</html>
