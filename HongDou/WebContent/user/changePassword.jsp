<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
</head>
	<script type="text/javascript">
		function checkOldPass(){
			var oldpass = $("#oldpass").val();
			if(oldpass==null||oldpass==""){
				alert("请输入旧密码");
			}
		}
		function checkAll(){
			var newpass =  $("#newpass").val();
			var newpass2 =  $("#newpass2").val();
			var oldpass = $("#oldpass").val();
			if(newpass==null||newpass==""){
				alert("请输入新密码");
				return false;
			}
			if(newpass2==null||newpass2==""){
				alert("请确认密码");
				return false;
			}
			if(newpass2!=newpass){
				alert("请保证新密码和确认密码一致!");
				$("#newpass").val("");
				$("#newpass2").val("");
				return false;
			}
			return true;
		}
		function checkPass(){
			var newpass =  $("#newpass").val();
			var oldpass = $("#oldpass").val();
			if(newpass==oldpass && newpass!=""){
				alert("新旧密码一致！请重新输入");
				$("#newpass").val("");
				$("#oldpass").val("");
			}
		}
	</script> 	
<body>
	<form id="from" action="${pageContext.request.contextPath}/user/comparePassWord" style="margin: 20px;" role="form" method="post" onsubmit="return checkAll()" >
		<div class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">旧密码:</label>
					
				<div class="col-sm-10">
					<input type="password" placeholder="请输入你的原始密码"  class="form-control" name="oldPassWord" id="oldpass"/>
				</div>
			</div>
				
			<div class="form-group">
					
				<label class="col-sm-2  control-label">新密码:</label>
					
				<div class="col-sm-10">
						<input type="password" placeholder="请输入你的新密码" class="form-control" name="newPassWord" id="newpass" onblur="checkPass()"/>
				</div>
			</div>
			<div class="form-group">
					
				<label class="col-sm-2  control-label">确认密码:</label>
					
				<div class="col-sm-10">
						<input type="password" placeholder="请输入你的新密码" class="form-control" name="checkPassword" id="newpass2"/>
				</div>
			</div>
		</div>
		<button type="submit" class=" btn btn-info btn-block">确认</button>
	</form> 
	<input type="hidden" id="wrong" value="${wrong}">
	<script type="text/javascript">
	$(function(){
		if($('#wrong').val()=="1"){
			alert("原密码错误!");
			}else if($('#wrong').val()=="2"){
				alert("密码修改成功!请使用新密码重新登陆")
				top.location.href="${pageContext.request.contextPath}/userLogin.jsp"
				}
	});
	</script>
	</body>
</html>