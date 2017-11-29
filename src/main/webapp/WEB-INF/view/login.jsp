<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link href="/BS/static/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/BS/static/jquery-easyui-1.5.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/BS/static/jquery-easyui-1.5.3/themes/icon.css">
<script type="text/javascript" src="/BS/static/js/jquery.min.js"></script>
<script type="text/javascript" src="/BS/static/js/jquery.easyui.min.js"></script>
</head>
<style type="text/css">
	#d2{
	height:100px;
	text-align:center;
	background-image: url("/BS/static/Images/t1.png");
	position: absolute;
	width:100%;
	top: 0;
	}
	h1{
	text-align:100px;
	}
	#d1{
		margin-top: 200px;
	}/* background-color:grey; */
	/* background-image: url("/BS/static/Images/t1.png") */
	body{
	width:100%;
	height:70%;
	background-image: url("/BS/static/Images/t3.png") 
	}
	body:hover{
	background-color:grey;
	} 
 	.tc_login{
 			width:30%;
 			heigth:15%;
			border:2px white solid;
	}
	/* .tc_login:hover{
			border:2px white solid;
	}  */
</style>
</head>
<body>	 
<div id="d2">
<h1 >BS用户管理系统</h1>
</div>
<div class="min" align="center" id="d1">
		<div class="tc_login">
			<div class="right">
			 <form method="POST" name="form_login" target="_top" id="dg">
				 <%-- <form action="${pageContext.request.contextPath }/BS/login" method="post"> --%>
					<div align="center">
						<i class="icon-mobile-phone"></i>
						<span>用户名称:</span>
						<input type="text" name="name" id="name"  placeholder="用户名" autocomplete="off" class="input_yh"><br/>
						<span>用户密码:</span>
					<input type="password" name="password" id="pass"  placeholder="密码" autocomplete="off" class="input_mm"><br/>
						
						<span>验证码:&emsp;</span><span>
						<!-- <input id="yz"    name="verifyCode" style="width:40%;margin-right:0px;height:30px;" /> -->
						<input type="yzm" name="verifyCode" id="yz" style="width:85px">
						<span>
					 <a href="#" class="imgCode" >
		                	<img  id="image" style="width:85px ;  vertical-align:middle; height:26px;"  onclick="fresh()" src="/BS/ImgServlet"  >
		                </a> 
					</span>
					</div>
					<div align="center">
						 <input type="button" class="button" title="Sign In" id="sb" value="登录"> 
						 &emsp;<input type="button" class="button" title="register" id="rs" onclick="register()" value="注册"> 
					</div>
				</form>   
			</div>		
		</div>
	</div>

<script type="text/javascript" src="/BS/static/js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){ 
		$(".min").mousedown(function(e){ 
			$(this).css("cursor","move");//改变鼠标指针的形状 
			var offset = $(this).offset();//DIV在页面的位置 
			var x = e.pageX - offset.left;//获得鼠标指针离DIV元素左边界的距离 
			var y = e.pageY - offset.top;//获得鼠标指针离DIV元素上边界的距离 
			$(document).bind("mousemove",function(ev){ //绑定鼠标的移动事件，因为光标在DIV元素外面也要有效果，所以要用doucment的事件，而不用DIV元素的事件 
				$(".min").stop();//加上这个之后 
				var _x = ev.pageX - x;//获得X轴方向移动的值 
				var _y = ev.pageY - y;//获得Y轴方向移动的值 
				$(".min").animate({left:_x+"px",top:_y+"px"},10); 
			}); 
		}); 
	});
</script>
<script type="text/javascript">
//登陆
		 function fresh(){
			 var timestamp = new Date().getTime();  
			$("#image").attr("src",'/BS/ImgServlet?random='+timestamp);
		}
 	$().ready(function () {
		$('#sb').click(function () {
			if ($('#name').val() == "" || $('#pass').val() == "") {
			alert("用户名或密码不能为空！");
				}else if($('#yz').val() == ""){
					alert("验证码不能为空");
				}
				else {
				$.ajax({
					type: "POST",
					url: "/BS/BS/login",
					data: "name=" + escape($('#name').val()) + "&password=" + escape($('#pass').val())+"&verifyCode=" + escape($('#yz').val()),
					success: function (data) {
						if(data.code==200){
							 alert("认证成功，请点击跳转页面！"); 
						/* 	setTimeout("location.href='Main';", 3000);  */
							 window.location.href="Main"; 
						}else if(data.code==250){
							alert("您输入有误,请重新输入！");
						}
				} 
			});
		}
	});
 }); 
 	function register(){
 		window.location.href="/BS/BS/register";
 	}
</script>
</body>
</html>
 