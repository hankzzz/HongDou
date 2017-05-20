<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>搜索结果</title>
<link rel="shortcut icon" type="image/x-icon"
	href="http://192.168.0.168:8080/HongDou/images/favicon.ico"
	media="screen" />
</head>
<body>
			<c:forEach items="${list}" var="question">
				id:<span>${question.id}</span><br/>
				标题:<span>${question.title}</span><br/>
				内容:<span>${question.content}</span><br/>
				发表时间:<span>${question.publishtime}</span><br/>
				类型:<span>${question.type}</span><br/>
				作者id:<span>${question.userid}</span><br/>
				浏览量:<span>${question.pageview}</span><br/>
				状态:<span>${question.status}</span><br/>
				作者:<span>${question.author}</span><br/>
				<hr><br/>
			</c:forEach>
</body>
</html>
