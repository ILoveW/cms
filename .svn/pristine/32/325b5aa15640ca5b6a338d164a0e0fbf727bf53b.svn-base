<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>BS栏目管理</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="/BS/static/htstatic/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="/BS/static/htstatic/plugin/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/BS/static/htstatic/plugin/easyui/themes/icon.css" />
	
		<script src="/BS/static/htstatic/plugin/easyui/jquery-3.2.1.min.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript"
	src="/BS/static/htstatic/plugin/easyui/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/BS/static/htstatic/plugin/easyui/popover.js"></script>
<script src="/BS/static/htstatic/plugin/easyui/jquery.easyui.min.js"
	type="text/javascript" charset="utf-8"></script>
		
		
		<link href="/BS/static/htstatic/css/bootstrap.min.css" rel="stylesheet">
		<link href="/BS/static/htstatic/css/tree/zTreeStyle.css" rel="stylesheet">
		<script type="text/javascript" src="/BS/static/htstatic/js/jquery.min.js"></script>
		<script type="text/javascript" src="/BS/static/htstatic/js/tree/jquery.ztree.core.js"></script>
		<script type="text/javascript" src="/BS/static/htstatic/js/tree/jquery.ztree.core.min.js"></script>
	<script typr="text/javascript">
		$(function(){
			var setting={
				data:{
					simpleData:{
						enable: true,
						idKey: "id",
						pIdKey: "pid",
						rootPId: -1,
					}
				},
				 view:{
					dblClickExpand: false,
					selectedMulti: false
				},
				async:{
						enable:true,
						url:"tree"
				}, 
				callback:{
					onClick:listChild
				}
			};
			function listChild(event,treeId,treeNode){
				alert(treeNode.id);
				$("#cc").attr("src","/BS/BS/tree/"+treeNode.id)
			}
			$.fn.zTree.init($("#tree"),setting);
		});
	</script>
</head>
<body>
<div class="easyui-layout" style="width: 100%; height: 700px;">
		<div data-options="region:'west',split:true" style="width: 155px;">
				<ul id="tree" class="ztree"></ul>
		</div>
		<div data-options="region:'center'">
			<IFRAME id="cc" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=600px ></IFRAME></TD>
		</div>
</div>
</body>
</html>