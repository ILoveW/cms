<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
	角色编号:
	<input class="easyui-textbox" data-options="prompt:'Enter a id'" id="search" style="width: 12%; height: 30px"> 角色名称:
	<input class="easyui-textbox" data-options="prompt:'Enter a name'" id="searchname" style="width: 12%; height: 30px"> 角色描述:
	<input class="easyui-textbox" data-options="prompt:'Enter a descrition'" id="searchebewrite"
		style="width: 12%; height: 30px">
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 80px" onclick="searchUser()">Search</a>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addUser()">添加</a>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="update()">修改</a>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="deleteUser()">删除</a>
	<table id="dg" title="角色管理" style="width: 100%; height: 350px"
		data-options="rownumbers:true,singleSelect:false,pagination:true,url:'/BS/role/Pages1',method:'get',fitColumns:'true',striped:true">
		<thead>
			<tr>
				<th data-options="field:'select',width:100,checkbox:true">Select</th>
				<th data-options="field:'role_id',width:120">编号</th>
				<th data-options="field:'role_name',width:120">角色名称</th>
				<th data-options="field:'role_bewrite',width:120,align:'right'">角色描述</th>
			</tr>
		</thead>
	</table>

	<div id="win2" class="easyui-window" title="添加角色信息" closed="true" style="width: 500px; height: 350px; padding: 5px;" align="center">
		<form id="fff" method="post">
			<div>
				<input class="easyui-textbox" type="text" name="role_id" label="角色编号" style="width: 100%"></input>
			</div>
			<div>
				<input class="easyui-textbox" type="text" name="role_name" label="角色名称" style="width: 100%"></input>
			</div>
			<div>
				<input class="easyui-textbox" type="text" name="role_bewrite" label="角色描述" style="width: 100%"></input>
			</div>
		</form>
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" id="ok" style="width: 90px">Save</a> <a
			href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript: $('#win2').window('close')" style="width: 90px">Cancel</a>
	</div>

	<div id="dlg" class="easyui-dialog" title="Basic Dialog" closed="true"
		data-options="iconCls:'icon-save'" style="width: 400px; height: 400px; padding: 10px;">
		<div class="easyui-panel" title="New Topic" style="width: 400px;">
			<div style="padding: 10px 60px 20px 60px">
				<form id="ff" method="post">
					<table cellpadding="5">
						<tr>
							<td>角色编号:</td>
							<td><input class="easyui-textbox" id="text1" name="role_id" readonly="readonly" value="id"></input></td>
						</tr>
						<tr>
							<td>角色名称:</td>
							<td><input class="easyui-textbox" type="text" id="text2" name="role_name"></input></td>
						</tr>
						<tr>
							<td>角色描述:</td>
							<td><input class="easyui-textbox" type="text" id="text3" name="role_bewrite"></input></td>
						</tr>
					</table>
				</form>
				<div style="text-align: center; padding: 5px">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="submit()">Submit</a> <a href="javascript:void(0)"
						class="easyui-linkbutton" onclick="clearForm()">Clear</a>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	/*加载datagrid数据*/
	$(function() {
		var pager = $('#dg').datagrid().datagrid('getPager');// get the pager of datagrid
		pager.pagination({

		});
	});
	/* 添加角色 */
	function addUser() {
		$('#win2').dialog('open').dialog('center').dialog('setTitle',
				'New User');
		$('#fff').form('clear');
	}
	$("#ok").on(
			"click",
			function adds() {
				if ($("input[name='role_id']").val() != ""
						&& $("input[name='role_name']").val() != ""
						&& $("input[name='role_bewrite']").val() != "") {
					$.ajax({
						cache : true,
						type : "POST",
						datatype : "text",
						url : "/BS/role/addRole",
						data : $('#fff').serialize(), // 你的formid
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
	/*修改用户 */
	function update() {
		var row = $('#dg').datagrid('getSelected');

		if (row) {
			$("#text1").textbox("setValue", row.role_id);
			$("#text2").textbox("setValue", row.role_name);
			$("#text3").textbox("setValue", row.role_bewrite);
		}
		$('#dlg').window('open');
	}
	function submit() {
		var role_id = $("#text1").val();
		var role_name = $("#text2").val();
		var role_bewrite = $("#text3").val();
		$.ajax({
			cache : true,
			type : "POST",
			url : "/BS/role/updateRole",
			//data:{"id":id,"name":name,"password":password,"email":email,"telphone":telphone,"Address":Address},
			async : false,
			data : $('#ff').serialize(), // 你的formid
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
	/* 删除用户*/
	function deleteUser() {
		var row = $('#dg').datagrid('getSelections');
		var i = 0;
		var string = "";
		for (i; i < row.length; i++) {
			string += row[i].role_id;
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
						url : "/BS/role/deleteRole",
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
	function searchUser() {
		$("#dg").datagrid('load', {
			role_id : $("#search").val(),
			role_name : $("#searchname").val(),
			role_bewrite : $("#searchebewrite").val()
		})
	}
	/*初始化分页数据*/
	$(document).ready(function() {
		$.ajax({
			url : "/BS/role/Pages1",
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