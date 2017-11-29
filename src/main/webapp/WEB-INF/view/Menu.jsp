<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/BS/static/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/BS/static/jquery-easyui-1.5.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/BS/static/jquery-easyui-1.5.3/themes/icon.css">
<script type="text/javascript" src="/BS/static/js/jquery.min.js"></script>
<script type="text/javascript" src="/BS/static/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/BS/static/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	菜单名称:<input class="easyui-textbox" data-options="prompt:'Enter a name'" id="searchname" style="width: 12%; height: 30px"> 
	菜单地址:<input class="easyui-textbox" data-options="prompt:'Enter a descrition'" id="searcheurl" style="width: 12%; height: 30px">
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 80px" onclick="searchUser()">Search</a>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addUser()">添加</a>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="update()">修改</a>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="deleteUser()">删除</a>
<table id="dg" title="菜单管理" style="width: 100%; height: 350px"
		data-options="rownumbers:true,singleSelect:false,pagination:true,url:'/BS/menu/Pages2',method:'get',fitColumns:'true',striped:true">
		<thead>
			<tr>
				<th data-options="field:'select',width:100,checkbox:true">Select</th>
				<th data-options="field:'menu_id',width:120">菜单编号</th>
				<th data-options="field:'menu_name',width:120">菜单名称</th>
				<th data-options="field:'menu_fid',width:120">菜单父编号</th>
				<th data-options="field:'menu_url',width:120,align:'right'">权限地址</th>
			</tr>
		</thead>
	</table>
	
	<div id="win2" class="easyui-window" title="添加菜单信息" closed="true" style="width: 500px; height: 350px; padding: 5px;" align="center">
		<form id="fff" method="post">
			<div>
				<input class="easyui-textbox" type="text" name="menu_id" label="菜单编号" style="width: 100%"></input>
			</div>
			<div>
				<input class="easyui-textbox" type="text" name="menu_name" label="菜单名称" style="width: 100%"></input>
			</div>
			<div>
				<input class="easyui-textbox" type="text" name="menu_fid" label="菜单父编号" style="width: 100%"></input>
			</div>
			<div>
				<input class="easyui-textbox" type="text" name="menu_url" label="菜单地址" style="width: 100%"></input>
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
							<td>菜单编号:</td>
							<td><input class="easyui-textbox" id="text1" name="menu_id" readonly="readonly" value="id"></input></td>
						</tr>
						<tr>
							<td>菜单名称:</td>
							<td><input class="easyui-textbox" type="text" id="text2" name="menu_name"></input></td>
						</tr>
						<tr>
							<td>菜单父编号:</td>
							<td><input class="easyui-textbox" type="text" id="text3" name="menu_fid"></input></td>
						</tr>
						<tr>
							<td>菜单地址:</td>
							<td><input class="easyui-textbox" type="text" id="text4" name="menu_url"></input></td>
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
/* 添加菜单 */
function addUser() {
	$('#win2').dialog('open').dialog('center').dialog('setTitle',
			'New User');
	$('#fff').form('clear');
}
$("#ok").on(
		"click",
		function adds() {
			if ($("input[name='menu_id']").val() != ""
					&& $("input[name='menu_name']").val() != ""
					&& $("input[name='menu_fid']").val() != ""
					/* && $("input[name='menu_url']").val() != "" */) {
				$.ajax({
					cache : true,
					type : "POST",
					datatype : "text",
					url : "/BS/menu/addMenu",
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
/*修改菜单 */
function update() {
	var row = $('#dg').datagrid('getSelected');

	if (row) {
		$("#text1").textbox("setValue", row.menu_id);
		$("#text2").textbox("setValue", row.menu_name);
		$("#text3").textbox("setValue", row.menu_fid);
		$("#text4").textbox("setValue", row.menu_url);
	}
	$('#dlg').window('open');
}
function submit() {
	var menu_id = $("#text1").val();
	var menu_name = $("#text2").val();
	var menu_fid = $("#text3").val();
	var menu_url =$("#text4").val();
	$.ajax({
		cache : true,
		type : "POST",
		url : "/BS/menu/updateMenu",
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
		string += row[i].menu_id;
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
					url : "/BS/menu/deleteMenu",
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
		menu_name : $("#searchname").val(),
		menu_url : $("#searcheurl").val()
	})
}
/*初始化分页数据*/
$(document).ready(function() {
	$.ajax({
		url : "/BS/menu/Pages2",
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