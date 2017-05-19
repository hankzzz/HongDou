<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>wangEditor2 test</title>
<link rel="stylesheet" type="text/css"
	href="http://192.168.0.168:8080/HongDou/wangEditor-2.1.23/dist/css/wangEditor.min.css">
	<link rel="shortcut icon" type="image/x-icon" href="http://192.168.0.168:8080/HongDou/images/favicon.ico" media="screen" />
   
<style type="text/css">
#editor-trigger {
	height: 400px;
	/*max-height: 500px;*/
}

.container {
	width: 100%;
	margin: 0 auto;
	position: relative;
}
</style>
</head>
<body style="padding: 0 20px;">
	<div id="editor-container" class="container">
		<div id="editor-trigger">
			<p>请输入内容</p>
		</div>
		
	</div>

	<script type="text/javascript"
		src="http://192.168.0.168:8080/HongDou/js/jquery-1.8.2.min.js"></script> 
	<script type="text/javascript"
		src="http://192.168.0.168:8080/HongDou/wangEditor-2.1.23/dist/js/wangEditor.js"></script>
	<script type="text/javascript"
		src="http://192.168.0.168:8080/HongDou/js/index.js"></script>
	<script type="text/javascript">
        // 阻止输出log
        // wangEditor.config.printLog = false;

        var editor = new wangEditor('editor-trigger');

       /*  // 上传图片
        editor.config.uploadImgUrl = '/upload';
        editor.config.uploadParams = {
            // token1: 'abcde',
            // token2: '12345'
        };
        editor.config.uploadHeaders = {
            // 'Accept' : 'text/x-json'
        }
        // editor.config.uploadImgFileName = 'myFileName';

        // 隐藏网络图片
        // editor.config.hideLinkImg = true;

        // 插入代码时的默认语言
        // editor.config.codeDefaultLang = 'html'

        // 只粘贴纯文本
        // editor.config.pasteText = true;

        // 跨域上传
        // editor.config.uploadImgUrl = 'http://localhost:8012/upload';

        // 第三方上传
        // editor.config.customUpload = true;

        // 普通菜单配置
        // editor.config.menus = [
        //     'img',
        //     'insertcode',
        //     'eraser',
        //     'fullscreen'
        // ];
        // 只排除某几个菜单（兼容IE低版本，不支持ES5的浏览器），支持ES5的浏览器可直接用 [].map 方法
        // editor.config.menus = $.map(wangEditor.config.menus, function(item, key) {
        //     if (item === 'insertcode') {
        //         return null;
        //     }
        //     if (item === 'fullscreen') {
        //         return null;
        //     }
        //     return item;
        // });

        // onchange 事件
        editor.onchange = function () {
            console.log(this.$txt.html());
        }; */

        editor.create();
    </script>
<!-- <div id="div1">
    <p>请输入内容...</p>
</div> -->
<button id="btn1" onclick="checkName()">获取内容</button>

<!--这里引用jquery和wangEditor.js-->
<!-- <script type="text/javascript">
    var editor = new wangEditor('div1');
    editor.create();
</script> -->
<script type="text/javascript">
/* $('#btn1').click(function () {
    // 获取编辑器区域完整html代码
    var html = editor.$txt.html();

    // 获取编辑器纯文本内容
    var text = editor.$txt.text();

    // 获取格式化后的纯文本
    var formatText = editor.$txt.formatText();
    
}); */
function checkName() {
	// 获取编辑器区域完整html代码
    var html = editor.$txt.html();

/*     // 获取编辑器纯文本内容
    var text = editor.$txt.text();

    // 获取格式化后的纯文本
    var formatText = editor.$txt.formatText(); */
	
    alert(html);
/*     alert(text);
    alert(formatText); */
} 
</script>
<form id="slick-login">
     <input type="text" id="title"  placeholder="请输入标题">
     <input type="number" id="type"   placeholder="请输入类型">
     <input type="button" name="" value="Add" id="sub" onclick="addAction()"/>
</form>
</body>
</html>
