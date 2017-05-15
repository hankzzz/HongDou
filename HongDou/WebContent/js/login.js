$(function(){
	$("#wrong").hide();
	console.log(222);
});

//用户名检查
function checkName(){
	var username = $("#name").val();
	if(username==null||username==""){
		alert("用户名不能为空");
		return false;
	}
	return true;
}
//检查密码
function checkPassword(){
	var password = $("#pwd").val();
		if(password==null||password==""){
			alert("密码不能为空");
			return false;
		}
		return true;
	}



//点击登录按钮执行
function loginAction(){
	var name=$('#name').val();
	var password=$('#pwd').val();
	var namePass=checkName();
	var pwdPass=checkPassword();
	$.ajax({
		url:'http://192.168.0.168:8080/HongDou/user/login',
		type:'post',
		data:{'username':name,'password':password},
		dataType:'JSON',
		success:function(result){
			if(result.status==true){
		
				console.log(result);
				
				
				
					window.location.href='index.html';
				
				//return ;
			}
			//登录失败
			var field=result.status;
		
			if(field==false){
				$("#wrong").show();
				return false;
				//$('#mess').empty().append(result.message);
			}
		}
	});
	
}
//响应回车事件
document.onkeydown = function(e) {  
var theEvent = e || window.event;  
var code = theEvent.keyCode || theEvent.which || theEvent.charCode;  
if (code == 13) {
	loginAction();
	 }  
};