<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title></title>
	<link rel="stylesheet" href="/BS/static/css/normalize.css" />
	<link rel="stylesheet" href="/BS/static/css/style.css" />
	<link rel="stylesheet" type="text/css" href="/BS/static/jquery-easyui-1.5.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/BS/static/jquery-easyui-1.5.3/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="/BS/static/css/demos.css">
	<script type="text/javascript" src="/BS/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="/BS/static/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/BS/static/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
	<style type="text/css">
			body{
				background-image: url("/BS/static/Images/t3.png");
				background-color:azure;
			}
			input{
				
			}
			.container{
				background-color:rgba(10, 150, 50, 0.13);
			}
		</style>
	
<body>
	<div  style="width:400px;padding:30px 60px;margin-top: 8%;margin-left:30%">
		<div class="container " style="width:400px;padding:30px 60px;">
	<form id="ffff">
		<div class="register-box">
		<span>用户名称:</span>
				<input name="user_name" style="margin-bottom: 5px;" class="easyui-validatebox textbox" data-options="prompt:'Enter User Name.',required:true,validType:'length[3,10]'" placeholder="用 户 名">
		</div>
		<div class="register-box">
		<span>用户密码:</span>
			<input maxlength="20" style="margin-bottom: 5px;" class="easyui-validatebox textbox" data-options="required:true"  name="user_password" type="password" placeholder="建议至少使用两种字符组合">
		</div>
		<div class="register-box">
		<span>用户邮箱:</span>
			<input maxlength="20"  style="margin-bottom: 5px;" class="easyui-validatebox textbox" data-options="required:true"  name="user_email" type="email" placeholder="请输入正确的邮箱">
		</div>
		<div class="register-box">
		<span>用户电话:</span>
			<input  class="easyui-validatebox textbox" style="margin-bottom: 5px;" data-options="required:true"  name="user_tel" maxlength="20" type="text" placeholder="建议使用常用手机">
		</div>	
		<div class="register-box">
		<span>用户地址:</span>
			<input maxlength="20" class="easyui-validatebox textbox" style="margin-bottom: 5px;" data-options="required:true"  name="user_adress" type="text" placeholder="请输入地址">
		</div>
		<div class="register-box">
		</div>
		<div class="submit_btn" >
					<button type="button" id="btn">立 即 注 册</button>
					<button type="button" id="register" onclick="logout()">退 出</button>
				</div>
	</form>
	</div>
</div>
 </body>
 <script type="text/javascript">
$(document).ready(function(){
$("#btn").on("click",function zhuce(){
	$.ajax({
		 cache: true,
         type: "POST",
         url:"/BS/BS/registerUser",
		data:{"user_name":$("input[name='user_name']").val(),"user_password":$("input[name='user_password']").val(),"user_email":$("input[name='user_email']").val(),"user_tel":$("input[name='user_tel']").val(),"user_adress":$("input[name='user_adress']").val(),"user_state":"1"},
         async: false,
         error: function(request) {
             alert("Connection error");
         },
         success: function(data) {
        	 if (data.code == 200) {
					alert("添加成功");
				} else if (data.code == 250) {
					alert("添加失败");
				} else if (data.code == 210) {
					alert("该用户已存在");
				} else {
					alert("出现异常");
				}
         }
			});
		});
		});
		
	function logout(){
		window.location.href="/BS/BS/logindemo";
	}
	</script>
</html>


