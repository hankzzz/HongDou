<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://192.168.0.168:80/HongDou/css/index.css" />
<link rel="shortcut icon" type="image/x-icon" href="http://192.168.0.168:80/HongDou/images/favicon.ico" media="screen" />
 <script src="http://192.168.0.168/HongDou/js/jquery-1.8.2.min.js"></script>
<title>红豆主页</title>
</head>
<script type="text/javascript">
function checkNull() {
	var keyword = $("#search").val();
	if(keyword!=null&&keyword!=""){
		document.getElementById("searchQuestion").submit();
	}else{
		alert("请输入内容！");
		return false;
	}
	
}
</script>
<body>
<div class="top">
     <div class="title">
         <span>
             <a class="bold" href="/HongDou/question/listOfQuestion">查看问题</a>&nbsp;
              <a class="bold" href="/HongDou/question/addQuestion.html">添加问题</a>
             <a class="bold" href="/HongDou/login.html">登录</a>&nbsp;
            <input class="list" type="submit" value="更多" name="submit" />&nbsp;
        </span>
    </div>
 </div>
<div class="body">
    <br><br><br><br><br><br><br><br>
    <div class="search">
        <form action="${pageContext.request.contextPath}/question/findQuestionByKeyword" method="post" id="searchQuestion">
            <label for="search"></label>
            <input class="input" type="text" name="keyword" id="search" value="" />
            <input class="btn" type="button" value="搜索 " name="sub" onclick="checkNull()"/>
        </form>
    </div>
</div>
<div class="foot">
    <div class="link">
        <a href="#">关于网站</a>&nbsp;
        <a href="#">About 202cb9</a>
    </div>
    <div class="copyright">
        <p>
            ©2017 202cb9 <a href="#">使用前必读</a> <a href="#">意见反馈</a> 
        </p>
    </div>
</div>
</body>
</html>