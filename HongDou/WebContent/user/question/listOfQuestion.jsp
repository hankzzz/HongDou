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
<title>全部问题列表</title>
<link rel="shortcut icon" type="image/x-icon"
	href="http://192.168.0.168:8080/HongDou/images/favicon.ico"
	media="screen" />
</head>
<body>
	<div class="zhishiku">
		<ul>
			<c:forEach items="${list}" var="question">
				<div class="liebiao">
					<h5 class="biaoti">
						<a>${question.id}</a>
					</h5>
					<a style="color: #b9b2ad"><c:set var="time"
							value="${question.publishtime}"></c:set> <c:set var="times"
							value="${fn:replace(time,'.0', '')}" /> ${times} </a> <a
						href="${pageContext.request.contextPath}/question/showQuestionByTime?questionId=${question.id}">标题(${question.title})</a>
					| <a>内容(${question.content})</a> | <a href="###">浏览量(${question.pageview})</a>
					| <a>评论量:${question.commentcount}</a>|<a>评论量:${question.author}</a>
				</div>
			</c:forEach>

			<!--这里是更换页面的按钮-->
			<div class="btn_changepage">
				<a>共${page.totalRecords}条记录 共${page.totalPages}页
					当前第${page.pageNo}页 <a
					href="${pageContext.request.contextPath}/question/listOfQuestion?pageNo=${page.getTopPageNo()}"><input
						type="button" name="fristPage" value="首页" class="btn btn-info" /></a>
					<c:choose>
						<c:when test="${page.pageNo!=1}">

							<a
								href="${pageContext.request.contextPath}/question/listOfQuestion?pageNo=${page.previousPageNo }"><input
								type="button" name="previousPage" value="上一页"
								class="btn btn-info" /></a>
						</c:when>
						<c:otherwise>

							<input type="button" disabled="disabled" name="previousPage"
								value="上一页" class="btn btn-info" />

						</c:otherwise>
					</c:choose> <c:choose>
						<c:when test="${page.pageNo != page.totalPages}">
							<a
								href="${pageContext.request.contextPath}/question/listOfQuestion?pageNo=${page.getNextPageNo() }"><input
								type="button" name="nextPage" value="下一页" class="btn btn-info" /></a>
						</c:when>
						<c:otherwise>

							<input type="button" disabled="disabled" class="btn btn-info"
								name="nextPage" value="下一页" />

						</c:otherwise>
					</c:choose> <a
					href="${pageContext.request.contextPath}/question/listOfQuestion?pageNo=${page.bottomPageNo }"><input
						type="button" name="lastPage" value="尾页" class="btn btn-info" /></a> <a
					id="ahref" href="#"
					onclick="location.href='${pageContext.request.contextPath}/question/listOfQuestion?pageNo='+document.getElementById('indexnum').value.trim()+'';"></a><input
					id="indexnum" type="text" /> <input type="button" value="点此跳转"
					class="btn btn-info" id="btn" onclick="test()" />
			</div>
		</ul>
	</div>
	<input type="hidden" id="totalpag" value="${page.totalPages} " />
	<script>
function test(){
var num=document.getElementById("indexnum").value.trim();
if(num==""){
	document.getElementById("indexnum").value="";
	alert("请输入内容!!");
	document.getElementById("ahref").onclick="";
	window.location.reload();
}else if(isNaN(num)){
	document.getElementById("indexnum").value="";
	alert("只能输入数字!");
	document.getElementById("ahref").onclick="";
	window.location.reload();
}else if(num>${page.totalPages}  || num<=0){
	document.getElementById("indexnum").value="";
	alert("请输入符合规范的页码！！");
    document.getElementById("ahref").onclick="";
	window.location.reload();
} 
}
</script>
</body>
</html>
