<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="/BS/static/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/BS/static/jquery-easyui-1.5.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/BS/static/jquery-easyui-1.5.3/themes/icon.css">
<script type="text/javascript" src="/BS/static/js/jquery.min.js"></script>
<script type="text/javascript" src="/BS/static/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/BS/static/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	用户名:<input class="easyui-textbox" data-options="prompt:'Enter a name'" id="search" style="width: 12%; height: 30px">
	电话:<input class="easyui-textbox" data-options="prompt:'Enter a tel'" id="searchtel" style="width: 12%; height: 30px">
	邮箱:<input class="easyui-textbox" data-options="prompt:'Enter a email'" id="searchemail" style="width: 12%; height: 30px">
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 80px" onclick="searchUser()">Search</a>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addUser()">添加</a>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="update()">修改</a>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="deleteUser()">删除</a>
	<table id="dg" title="用户管理" style="width: 100%; height: 350px"
		data-options="rownumbers:true,singleSelect:false,pagination:true,url:'/BS/BS/Pages',method:'get',fitColumns:'true',striped:true">
		<thead>
			<tr>
				<th data-options="field:'select',width:100,checkbox:true">Select</th>
				<th data-options="field:'user_id',width:120">编号</th>
				<th data-options="field:'user_name',width:60">姓名</th>
				<th data-options="field:'user_password',width:120,align:'right'">密码</th>
				<th data-options="field:'user_tel',width:80,align:'right'">电话</th>
				<th data-options="field:'user_email',width:120,align:'right'">邮箱</th>
				<th data-options="field:'user_adress',width:200">地址</th>
				<th data-options="field:'user_date',width:80,align:'right'">注册日期</th>
				<th data-options="field:'user_state',width:60,align:'center'">状态</th>
			</tr>
		</thead>
	</table>
	<div id="win2" class="easyui-window" title="添加用户信息" closed="true"
		style="width: 500px; height: 350px; padding: 5px;" align="center">
		<form id="fff" method="post">
			<!-- <div>
				<input class="easyui-textbox" type="text" name="user_id"
					label="用户编号" style="width: 100%"></input>
			</div> -->
			<div>
				<input class="easyui-textbox" type="text" name="user_name"
					label="姓名" style="width: 100%"></input>
			</div>
			<div>
				<input class="easyui-textbox" type="text" name="user_password"
					label="密码" style="width: 100%"></input>
			</div>
			<div>
				<input class="easyui-textbox" name="user_email" label="邮箱"
					style="width: 100%"></input>
			</div>
			<div>
				<input class="easyui-textbox" name="user_tel" label="电话"
					style="width: 100%"></input>
			</div>
			<div>
				<input class="easyui-textbox" name="user_adress" label="地址"
					style="width: 100%"></input>
			</div>
			<div>
				<!-- <input class="easyui-textbox" type="text" name="user_state"
					label="状态" style="width: 100%"></input> -->
					<tr><th>状态：</th><td><input type="radio" name="user_state1"  name="u_status" value="1"><span>启用</span>
          			<input type="radio" name="user_state1" checked value="0"><span>未启用 </span></td></tr>
			</div>
		</form>
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" id="ok" style="width: 90px">Save</a>
		 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript: $('#win2').window('close')" style="width: 90px">Cancel</a>
	</div>
	<div id="dlg" class="easyui-dialog" title="Basic Dialog" closed="true" data-options="iconCls:'icon-save'"
		style="width: 400px; height: 400px; padding: 10px;">
		<div class="easyui-panel" title="New Topic" style="width: 400px;">
			<div style="padding: 10px 60px 20px 60px">
				<form id="ff" method="post">
					<table cellpadding="5">
						<tr>
							<td><input class="easyui-textbox" type="hidden" id="text1"
								name="user_id" readonly="readonly" value="id"></input></td>
						</tr>
						<tr>
							<td>姓名:</td>
							<td><input class="easyui-textbox" type="text" id="text2"
								name="user_name" readonly="readonly"></input></td>
						</tr>
						<tr>
							<td>密码:</td>
							<td><input class="easyui-textbox" type="text" id="text3"
								name="user_password"></input></td>
						</tr>
						<tr>
							<td>邮箱:</td>
							<td><input class="easyui-textbox" type="email" id="text4"
								name="user_email"></input></td>
						</tr>
						<tr>
							<td>电话:</td>
							<td><input class="easyui-textbox" type="text" id="text5"
								name="user_tel"></td>
						</tr>
						<tr>
							<td>地址:</td>
							<td><input class="easyui-textbox" type="text" id="text6"
								name="user_adress"></td>
						</tr>
						<tr>
							<td>注册日期:</td>
							<td><input class="easyui-textbox" type="text" id="text7"
								name="user_date"></input></td>
						</tr>
						<tr>
							<!-- <td>状态:</td>
							<td><input class="easyui-textbox" type="text" id="text8"
								name="user_state"></input></td> -->
							<tr><th>状态：</td><th><input type="radio" name="user_state2"  value="1"><span>启用</span>
          			<input type="radio" name="user_state2" checked value="0"><span>不启用 </span></td></tr>
			
						</tr>
					</table>
				</form>
				<div style="text-align: center; padding: 5px">
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submit()">Submit</a> <a href="javascript:void(0)"
						class="easyui-linkbutton" onclick="clearForm()">Clear</a>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		var pager = $('#dg').datagrid().datagrid('getPager');// get the pager of datagrid
		pager.pagination({

		});
	});
	/* 添加用户 */
	function addUser() {
		$('#win2').dialog('open').dialog('center').dialog('setTitle',
				'New User');
		$('#fff').form('clear');
	}
	$("#ok").on(
			"click",
			function adds() {
				var radio = document.getElementsByName("user_state1");  
			    for (i=0; i<radio.length; i++) {  
			        if (radio[i].checked) { 
			        var user_state=radio[i].value; 
			        }  
			    }  
				if (/* $("input[name='user_id']").val() != ""
						&& */ $("input[name='user_name']").val() != ""
						&& $("input[name='user_password']").val() != ""
						/* && $("input[name='user_state']").val() != "" */
						&&user_state!=""
						&& $("input[name='user_email']").val() != ""
						&& $("input[name='user_tel']").val() != ""
						&& $("input[name='user_adress']").val() != "") {
					$.ajax({
						cache : true,
						type : "POST",
						datatype : "text",
						url : "/BS/BS/addUser",
						/* data : $('#fff').serialize(), */// 你的formid
						data:{"user_name":$("input[name='user_name']").val(),"user_password":$("input[name='user_password']").val(),"user_email":$("input[name='user_email']").val(),"user_tel":$("input[name='user_tel']").val(),"user_adress":$("input[name='user_adress']").val(),"user_state":user_state},
						async : false,
						error : function(request) {
							alert("Connection error");
						},
						success : function(data) {
							if (data.code == 200) {
								alert("添加成功");
								$('#dg').datagrid("reload");
								/* window.location.reload(); */
							} else if (data.code == 250) {
								alert("添加失败");
							} else if (data.code == 210) {
								alert("该用户已存在");
							} else {
								alert("出现异常");
							}
						}
					});
				} else {
					alert("请完善个人信息");
				}

			});
	/* 删除用户*/
	function deleteUser() {
		var row = $('#dg').datagrid('getSelections');
		var i = 0;
		var string = "";
		for (i; i < row.length; i++) {
			string += row[i].user_id;
			if (i < row.length - 1) {
				string += ',';
			} else {
				break;
			}
		}
		if (row.length == 0) {
			alert("请选择要删除的行");
		}
		if (row.length > 0) {
			$.messager.confirm('Confirm', '确定删除用户?', function(r) {
				if (r) {
					var row = $('#dg').datagrid('getSelected');
					$.ajax({
						cache : true,
						type : "POST",
						url : "/BS/BS/deletebyId",
						/*  data:{id:row.user_id}, */// 你的formid
						data : {
							id : string
						},
						async : false,
						error : function(request) {
							alert("Connection error");
						},
						success : function(data) {
							if (data.code == 200) {
								alert("删除成功");
								$('#dg').datagrid("reload");
								/* window.location.reload(); */
							} else if (data.code == 250) {
								alert("删除失败");
							} else {
								alert("出现异常");
							}
						}
					});
				}
			});
		}
	}
	/*修改用户 */
	function update() {
		var row = $('#dg').datagrid('getSelected');

		if (row) {
			$("#text1").textbox("setValue", row.user_id);
			$("#text2").textbox("setValue", row.user_name);
			$("#text3").textbox("setValue", row.user_password);
			$("#text4").textbox("setValue", row.user_email);
			$("#text5").textbox("setValue", row.user_tel);
			$("#text6").textbox("setValue", row.user_adress);
			$("#text7").textbox("setValue", row.user_date);
			$('#dlg').window('open');
		}
		else{
			alert("请选中要修改的行！");
		}
		
	}
	function submit() {
		 var radio1 = document.getElementsByName("user_state2");  
		 for (i=0; i<radio1.length; i++) {  
	        if (radio1[i].checked) { 
	        var user_state=radio1[i].value; 
	        }  
	    } 
		var user_id = $("#text1").val();
		var user_name = $("#text2").val();
		var user_password = $("#text3").val();
		var user_email = $("#text4").val();
		var user_tel = $("#text5").val();
		var user_adress = $("#text6").val();
		var user_date = $("#text7").val();
	    /* var user_state = $("#text8").val(); */
		$.ajax({
			cache : true,
			type : "POST",
			url : "/BS/BS/updateUser",
			//data:{"id":id,"name":name,"password":password,"email":email,"telphone":telphone,"Address":Address},
			async : false,
			/* data : $('#ff').serialize(), */// 你的formid
			data:{"user_id":user_id,"user_name":user_name,"user_password":user_password,"user_email":user_email,"user_tel":user_tel,"user_adress":user_adress,"user_date":user_date,"user_state":user_state},
			async : false,
			error : function(request) {
				alert("Connection error");
			},
			success : function(data) {
				if (data.code == 200) {
					alert("修改成功");
					window.location.reload();
				} else if (data.code == 250) {
					alert("修改失败");
				} else {
					alert("出现异常");
				}
			}
		});
		window.location.reload();
	}
	//查询用户
	/* 	 	function searchUser(){
	 var search=$("#search").val();
	 alert(search);
	 $.ajax({
	 url:"/BS/BS/Pages",
	 type:"get",
	 data:{name:search,page:"1",rows:"10"},	 
	 dataType:"json",
	 success:function(data){
	 $("#dg").datagrid('reload'); 
	 }
	 });
	 }  */
	function searchUser() {
		$("#dg").datagrid('load', {
			name : $("#search").val(),
			tel : $("#searchtel").val(),
			email : $("#searchemail").val()
		})
	}
	/*清空弹框内容  */
	function clearForm() {
		$('#ff').form('clear');
	}
	/*初始化分页数据*/
	$(document).ready(function() {
		$.ajax({
			url : "/BS/BS/Pages",
			type : "get",
			data : {
				page : "1",
				rows : "10"
			},
			dataType : "json",
			success : function(data) {
			}
		});
	});
</script>
</html>