<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

<html>
<head>
<title>角色管理</title>
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
<script src="resources/laydate/laydate.js"></script>
<script type="text/javascript" src="resources/script/validateUtil.js"></script>
<script src="resources/script/jquery.easyui.min.js"></script>


</head>
<body>

	<c:if test="${!empty roleBean.role.id}">
		<c:url var="editRoleAction" value="/role/roleEdit"></c:url>
	</c:if>
	<c:if test="${empty roleBean.role.id}">
		<c:url var="editRoleAction" value="/role/roleAdd"></c:url>
	</c:if>


	<form:form action="${editRoleAction}" modelAttribute="roleBean"
		method="post" id="roleForm">

		<form:hidden path="nameParam" id="param_name" />

		<form:hidden path="role.id" />

		<table>
		
			<c:if test="${!empty roleBean.role.id}">
				<tr>
				<td class="td-left"><form:label path="role.roleName">
						<spring:message text="角色名" />
					</form:label></td>
				<td class="td-right"><form:input path="role.roleName" class="easyui-validatebox form-input"
						required="true" missingMessage="角色名不能为空" readonly="true"/></td>
			</tr>

				<tr>
					<td><form:label path="role.description">
							<spring:message text="角色描述" />
						</form:label></td>
					<td><form:input path="role.description"
							class="easyui-validatebox form-input" required="true"
							missingMessage="角色描述不能为空" readonly="true"/></td>
				</tr>
			</c:if>
		
			<c:if test="${empty roleBean.role.id}">
				<tr>
				<td class="td-left"><form:label path="role.roleName">
						<spring:message text="角色名" />
					</form:label></td>
				<td class="td-right"><form:input path="role.roleName" class="easyui-validatebox form-input"
						required="true" missingMessage="角色名不能为空" /></td>
			</tr>

				<tr>
					<td><form:label path="role.description">
							<spring:message text="角色描述" />
						</form:label></td>
					<td><form:input path="role.description"
							class="easyui-validatebox form-input" required="true"
							missingMessage="角色描述不能为空" /></td>
				</tr>
			</c:if>
			

			<tr>
				<td><form:label path="selectePermissions">
						<spring:message text="权限列表" />
					</form:label></td>
				<td><input type="checkbox" id="allResourcesId"> <span>所有权限</span>
					<div class="cbs">
						<form:checkboxes path="selectePermissions" items="${roleBean.permissionList}"
							itemLabel="description" itemValue="id" />
					</div></td>
			</tr>

			<tr>
				<td colspan="2"><c:if test="${!empty roleBean.role.id}">
						<input type="button" class="searchField btn btn-primary"
							value="<spring:message text="修改"/>" onclick="editRole()" />
					</c:if> <c:if test="${empty roleBean.role.id}">
						<input type="button" class="searchField btn btn-primary"
							value="<spring:message text="添加"/>" onclick="addRole()" />
					</c:if> <input type="button" class="searchField btn btn-primary"
					value="<spring:message text="取消"/>" onclick="cancel()" /></td>
			</tr>
		</table>
	</form:form>

	<script>
		function editRole() {
			$('#roleForm').form('submit',{
				onSubmit:function(){
					return  $(this).form('validate');
				},
				success:function(data){
					var name = $("#param_name").val();
					var queryStr = 'name=' + name ;
					window.location.href='role/roleList?' + queryStr;
				}
			});
		}

		function addRole() {
			$('#roleForm').form('submit',{
				onSubmit:function(){
					return  $(this).form('validate');
				},
				success:function(data){
					var name = $("#param_name").val();
					var queryStr = 'name=' + name ;
					window.location.href='role/roleList?' + queryStr;
				}
			});
		}

		function cancel() {
			var name = $("#param_name").val();
			var queryStr = 'name=' + name;
			window.location.href = 'role/roleList?' + queryStr;
		}
		
		$(document).ready(function() {
			
			$("input[name='selectePermissions']").each(function(){
				if(!$(this).checked){
					$("#allResourcesId").prop("checked",false);
				} 
		
				if($("input[name='selectePermissions']").length == $("input[name='selectePermissions']:checked").length) {
					$("#allResourcesId").prop("checked",true);
				}
		
			}); 
				
				$("#allResourcesId").click(function() {
					$("input[name='selectePermissions']").prop("checked",this.checked);
				});
			
				$("input[name='selectePermissions']").each(function(){
					 $(this).click( function(){
						if(!$(this).checked){
							$("#allResourcesId").prop("checked",false);
						} 
						
						if($("input[name='selectePermissions']").length == $("input[name='selectePermissions']:checked").length) {
							$("#allResourcesId").prop("checked",true);
						}
					});
				}); 
		});
	</script>


</body>
</html>