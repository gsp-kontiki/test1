<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

<html>
<head>
<title>用户管理</title>
<style type="text/css">
</style>

<link href="resources/css/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/css/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">
<link href="resources/css/dist/css/sb-admin-2.css" rel="stylesheet">
<link href="resources/css/vendor/morrisjs/morris.css" rel="stylesheet">
<link href="resources/css/vendor/font-awesome/css/font-awesome.min.css">
<link href="resources/css/browser.css" rel="stylesheet" />
<link href="resources/css/themes/default/easyui.css" rel="stylesheet" />

<script src="resources/jquery/jquery-3.0.0.min.js"></script>
<script src="resources/script/jquery.easyui.min.js"></script>

</head>
<body>

	<c:url var="editUserAction" value="/user/userPasswordChange"></c:url>


	<form:form action="${editUserAction}" modelAttribute="userBean"
		method="post" enctype="multipart/form-data" id="userForm">
		<form:hidden path="user.salt" />
		<form:hidden path="user.id" />
		<form:hidden path="user.password" id="password_1"/>
		<form:hidden path="user.locked" />

		<table>
		
			<tr>
				<td class="td-left"><form:label path="user.username">
						<spring:message text="名称" />
					</form:label></td>
				<td class="td-right"><form:input path="user.username"
						id="user_name" class="easyui-validatebox form-input" readonly ="true"
						required="true" missingMessage="名称不能为空" /></td>
			</tr>
			
			<tr>
				<td class="td-left"><form:label path="oldPassword">
						<spring:message text="原密码" />
					</form:label></td>
				<td class="td-right"><form:password path="oldPassword"
						id="user_name" class="easyui-validatebox form-input" 
						required="true" missingMessage="原密码不能为空" /></td>
			</tr>
			
			<tr>
				<td class="td-left"><form:label path="password">
						<spring:message text="新密码" />
					</form:label></td>
				<td class="td-right"><form:password path="password"
						id="user_password" class="easyui-validatebox form-input"
						required="true" missingMessage="密码不能为空" /></td>
			</tr>
			<tr>
				<td class="td-left"><form:label path="retryPassword">
						<spring:message text="重复密码" />
					</form:label></td>
				<td class="td-right"><form:password path="retryPassword"
						id="user_name" class="easyui-validatebox form-input"
						required="true" missingMessage="重复密码不能为空 "
						validType="equals['#user_password']" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="button"
					class="searchField btn btn-primary"
					value="<spring:message text="修改"/>" onclick="editUser()" /> <input
					type="button" class="searchField btn btn-primary"
					value="<spring:message text="取消"/>" onclick="cancel()" /></td>
			</tr>
		</table>
	</form:form>

	<script>
		function editUser() {
			$('#userForm').form('submit', {
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(data) {
					if(data.indexOf("原密码不一致")!=-1){
						alert("原密码不一致,请重新输入");
					}else{
						var name = $("#param_name").val();
						var queryStr = 'name=' + name;
						window.location.href = 'user/userList?' + queryStr;
					}
				}
			});
		}

		function cancel() {
			var name = $("#param_name").val();
			var queryStr = 'name=' + name;
			window.location.href = 'user/userList?' + queryStr;
		}

		$.extend($.fn.validatebox.defaults.rules, {
			equals : {
				validator : function(value, param) {
					return value == $(param[0]).val();
				},
				message : '重复密码不一致'
			}
		});
	</script>


</body>
</html>