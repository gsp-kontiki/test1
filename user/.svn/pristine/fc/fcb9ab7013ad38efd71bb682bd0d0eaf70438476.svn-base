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
<title>角色管理</title>
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


	<div id="roleDiv" style="margin-top: 10px;">
		<div>
			<div style="text-align: left; margin-left: 30px;">
				<table id="roleTable"></table>
			</div>

		</div>
	</div>

	<script>
		$(document).ready(function() {
			loadDataTable();
		});

		function loadDataTable() {
			var name = $("#param_name").val();

			var url = 'role/roleJsonList';
			var queryStr = '&name=' + name;
			$('#roleTable')
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
												window.location.href = 'role/goRoleAdd?'
														+ queryStr;
											}
										},
										'-',
										{
											text : '删除',
											iconCls : 'icon-remove',
											handler : function() {
												var rows = $('#roleTable')
														.datagrid('getChecked');
												if (rows.length > 0) {
													if (confirm("确定删除吗？")) {
														var ids = [];
														for (var i = 0; i < rows.length; i++) {
															ids.push(rows[i].id);
														}
														var idStr = ids.join(',');
														window.location.href = 'role/roleRemove?id='+ idStr+ '&'+ queryStr;
													}
												} else {
													alert('请选择要删除的记录');
												}
											}
										},
										'-',
										{
											text : '分配权限',
											iconCls : 'icon-edit',
											handler : function() {
												var rows = $('#roleTable')
														.datagrid('getChecked');
												if (rows.length == 0) {
													alert('请选择要分本权限的角色');
												} else if (rows.length > 1) {
													alert('只能选择一个角色');
												} else {
													var id = rows[0].id;
													window.location.href = 'role/goRoleEdit?id='+ id+ '&'+ queryStr;
												}
											}
										}

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
											field : 'roleName',
											title : '角色名',
											width : 80,
											align : 'center',
										},
										{
											field : 'description',
											title : '角色描述',
											width : 80,
											align : 'center'
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