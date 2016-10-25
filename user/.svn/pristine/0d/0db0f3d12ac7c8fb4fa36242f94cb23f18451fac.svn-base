<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

<html>
<head>
<base href="<%=basePath%>">
<title>用户管理</title>
<style type="text/css">

.dataTable {
	margin: 0 auto;
	width: 800px;
	height: 400px;
	margin-bottom: 80px;
}
.searchField {
	margin-left: 35px;
}
/* 自动换行*/
.datagrid-btable .datagrid-cell {
	word-break: break-all;
}
</style>
	<link rel="stylesheet" type="text/css" href="resources/css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="resources/css/themes/icon.css">
	<link href="resources/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<script type="text/javascript" src="resources/script/dataUtil.js"></script>
	<script type="text/javascript" src="resources/jquery/jquery-3.0.0.min.js"></script>
	<script type="text/javascript" src="resources/script/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/script/easyui-lang-zh_CN.js"></script>
</head>
<body>

	<div class="form-inline">
		<%@ include file="/WEB-INF/views/common/search_name.jsp"%>
		<%@ include file="/WEB-INF/views/common/search_button.jsp"%>
	</div>


	<div id="userDiv" style="margin-top: 10px;">
		<div>
			<div style="text-align: left; margin-left: 30px;">
				<table id="userTable"></table>
			</div>

		</div>
	</div>

	<script>
		var editIndex = undefined;
		$(document).ready(function() {
			loadDataTable();
		});

		function loadDataTable() {
			var name = $("#param_name").val();

			var url = 'user/userJsonList';
			var queryStr = '&name=' + name;
			$('#userTable')
					.datagrid(
							{
								url : url,
								width : ($(window).width() * 0.90),
								height : 700,
								fitColumns : true,
								nowrap : false,
								showFooter : true,
								pagination : true,
								//pageSize : 10,
								pageList : [ 10, 20, 30, 40, 50 ],
								pageNumber : 1,
								rownumbers : true,
								checkOnSelect : false,
								queryParams : {
									name : name
								},
								idField : 'id',
								toolbar : [
										{
											text : '添加',
											iconCls : 'icon-add',
											handler : function() {
												window.location.href = 'user/goUserAdd?'
														+ queryStr;
											}
										},'-',
										{
											text : '删除',
											iconCls : 'icon-remove',
											handler : function() {
												var rows = $('#userTable')
														.datagrid('getChecked');
												if (rows.length > 0) {
													if (confirm("确定删除吗？")) {
														var ids = [];
														for (var i = 0; i < rows.length; i++) {
															ids.push(rows[i].id);
														}
														var idStr = ids.join(',');
														window.location.href = 'user/userRemove?id='+ idStr+ '&'+ queryStr;
													}
												} else {
													alert('请选择要删除的记录');
												}
											}
										},
										'-',
										{
											text : '分配角色',
											iconCls : 'icon-edit',
											handler : function() {
												var rows = $('#userTable')
														.datagrid('getChecked');
												if (rows.length == 0) {
													alert('请选择要分配角色的用户');
												} else if (rows.length > 1) {
													alert('只能选择一个用户');
												} else {
													var id = rows[0].id;
													window.location.href = 'user/goUserEdit?id='+ id+ '&'+ queryStr;
												}
											}
										}
										
										
										/**
										,
										'-',
										{
											text : '修改密码',
											iconCls : 'icon-lock',
											handler : function() {
												var rows = $('#userTable')
														.datagrid('getChecked');
												if (rows.length == 0) {
													alert('请选择要修改的记录');
												} else if (rows.length > 1) {
													alert('只能修改一条记录');
												} else {
													var id = rows[0].id;
													window.location.href = 'user/goUserPasswordChange?id='+ id+ '&'+ queryStr;
												}
											}
										}
										**/

								],
								columns : [ [
										{
											field : 'ck',
											checkbox : true,
											align : 'left',
											width : 30
										},
										{
											field : 'id',
											title : 'ID',
											width : 80,
											align : 'center'
										},
										{
											field : 'userName',
											title : '用户名',
											width : 80,
											align : 'center',
										},
										{
											field : 'roleNames',
											title : '角色列表',
											width : 80,
											align : 'center',
										},
										{
											field : 'locked',
											title : '状态',
											width : 80,
											align : 'center',
											formatter : function(value, row,index) {
												if (value == false) {
													return '正常';
												} else {
													return '锁定';
												}
											}
										} ] ],
							
								rowStyler : function(index, row) {
									if(index%2 == 0) {
										return 'background-color:#f9f9f9;';
									} else {
										return 'background-color:#fff;';
									}
								}

							});
		}

		function search() {
			loadDataTable();
		}
	</script>
</body>
</html>