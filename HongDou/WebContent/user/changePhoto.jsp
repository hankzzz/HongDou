<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改头像</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/changePhoto" method="post" enctype="multipart/form-data"  onsubmit="return checkPhoto(this)">
	请选择头像:<input type="file" name="filePhoto" id="filesize">
	<input type="submit" value="上传">
</form>
<input type="hidden" id="photo" value="${applicationScope.photo}"/>
<input type="hidden" id="maxSize" value="${applicationScope.maxSize}"/>
<script>
function checkPhoto(myupload){
	var file=document.getElementById("filesize");
	var types=file.value.substr(file.value.lastIndexOf(".")+1).toLowerCase();
	if(file.value==""){		
		alert("请选择图片后上传");
		return false;
	}else if(types!="jpg" && types!="png" && types!="bmp"){
		alert("只能上传jpg,png,bmp格式的图片");
		return false;
	}
	
}
</script>
</body>
</html>