$(function() {
	$("#wrong").hide();
	console.log(222);
});

//检查标题
function checkTitle() {
	var title = $("#title").val();
	if (title == null || title == "") {
		alert("标题不能为空");
		return false;
	} else {
		return true;
	}

}
// 检查类型
function checkType() {
	var type = $("#type").val();
	if (type == null || type == "") {
		alert("类型不能为空");
		return false;
	} else {
		return true;
	}

}

// 点击登录按钮执行
function addAction() {
	var content = editor.$txt.html();//获取编辑器内容
	var title = $('#title').val();
	var type = $('#type').val();
	var titlePass = checkTitle();
	var typePass = checkType();
	if(typePass==true&&titlePass==true){
		$.ajax({
			url : 'http://192.168.0.168:8080/HongDou/question/addQuestion',
			type : 'post',
			data : {
				'content' : content,
				'title' : title,
				'type' : type
			},
			dataType : 'JSON',
			success : function(result) {
				if (result.status == true) {

					console.log(result);

					window.location.href = 'success.html';

					// return ;
				}
				// 登录失败
				var field = result.status;

				if (field == false) {
					$("#wrong").show();
					return false;
					// $('#mess').empty().append(result.message);
				}
			},
		});

	}
	}
	
// 响应回车事件
document.onkeydown = function(e) {
	var theEvent = e || window.event;
	var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
	if (code == 13) {
		loginAction();
	}
};