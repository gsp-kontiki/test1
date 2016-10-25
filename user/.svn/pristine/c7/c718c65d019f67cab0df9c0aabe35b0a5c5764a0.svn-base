<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

<html>
<head>
<title>资源管理</title>
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

<script src="resources/jquery/jquery-3.0.0.min.js"></script>
<script src="resources/laydate/laydate.js"></script>
<script type="text/javascript" src="resources/script/validateUtil.js"></script>
<script src="resources/script/jquery.easyui.min.js"></script>
<script src="resources/laydate/laydate.js"></script>
<script type="text/javascript" src="resources/script/validateUtil.js"></script>


</head>
<body>

	<c:if test="${!empty resourceBean.resource.id}">
		<c:url var="editResourceAction" value="/resource/resourceEdit"></c:url>
	</c:if>
	<c:if test="${empty resourceBean.resource.id}">
		<c:url var="editResourceAction" value="/resource/resourceAdd"></c:url>
	</c:if>


	<form:form action="${editResourceAction}" modelAttribute="resourceBean"
		method="post" enctype="multipart/form-data" id="resourceForm">

		<form:hidden path="nameParam" id="param_name" />
		<form:hidden path="resource.id" />
		<form:hidden path="resource.available" />
		<form:hidden path="resource.parentId" />
		<form:hidden path="resource.parentIds" />

		<table>

			<c:if test="${not empty parent}">
				<div class="form-group">
					<label>父节点名称：</label> ${parent.name}
				</div>
			</c:if>

			<tr>
				<td class="td-left"><form:label path="resource.name">
				<c:if test="${not empty parent}">子</c:if>
						<spring:message text="名称" />
					</form:label></td>
				<td class="td-right"><form:input path="resource.name"
						class="easyui-validatebox form-input" required="true"
						missingMessage="资源名不能为空" /></td>
			</tr>

			<tr>
				<td><form:label path="resource.description">
						<spring:message text="描述" />
					</form:label></td>
				<td><form:input path="resource.description"
						class="easyui-validatebox form-input" required="true"
						missingMessage="资源描述不能为空" /></td>
			</tr>

			<tr>
				<td><form:label path="resource.permission">
						<spring:message text="权限字符串" />
					</form:label></td>
				<td><form:input path="resource.permission"
						class="easyui-validatebox form-input" required="true"
						missingMessage="资源描述不能为空" /></td>
			</tr>

			<tr>
				<td colspan="2"><c:if test="${!empty resourceBean.resource.id}">
						<input type="button" class="searchField btn btn-primary"
							value="<spring:message text="修改"/>" onclick="editResource()" />
					</c:if> <c:if test="${empty resourceBean.resource.id}">
						<input type="button" class="searchField btn btn-primary"
							value="<spring:message text="添加"/>" onclick="addResource()" />
					</c:if> <input type="button" class="searchField btn btn-primary"
					value="<spring:message text="取消"/>" onclick="cancel()" /></td>
			</tr>
		</table>
	</form:form>

	<script>
		function editResource() {
			var valid = isValid();
			if (valid) {
				$("#resourceForm").submit();
			}
		}

		function addResource() {
			$('#resourceForm').form('submit',{
				onSubmit:function(){
					return  $(this).form('validate');
				},
				success:function(data){
					var name = $("#param_name").val();
					var queryStr = 'name=' + name ;
					window.location.href='resource/resourceList?' + queryStr;
				}
			});
		}

		function cancel() {
			var name = $("#param_name").val();
			var queryStr = 'name=' + name;
			window.location.href = 'resource/resourceList?' + queryStr;
		}
		
		$(document).ready(function() {
				
				$("#allResourcesId").click(function() {
					$("input[name='selectResources']").prop("checked",this.checked);
				});
			
				$("input[name='selectResources']").each(function(){
					 $(this).click( function(){
						if(!$(this).checked){
							$("#allResourcesId").prop("checked",false);
						} 
						
						if($("input[name='selectResources']").length == $("input[name='selectResources']:checked").length) {
							$("#allResourcesId").prop("checked",true);
						}
					});
				}); 
		});
	</script>


</body>
</html>