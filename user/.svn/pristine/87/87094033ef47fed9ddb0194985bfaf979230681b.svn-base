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
	rel="stylesheet"/>
<link href="resources/css/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet"/>
<link href="resources/css/dist/css/sb-admin-2.css" rel="stylesheet"/>
<link href="resources/css/vendor/morrisjs/morris.css" rel="stylesheet"/>
<link href="resources/css/vendor/font-awesome/css/font-awesome.min.css"/>
<link href="resources/css/browser.css" rel="stylesheet" />
<link href="resources/css/themes/default/easyui.css" rel="stylesheet" />

<script src="resources/jquery/jquery-3.0.0.min.js"></script>
<script src="resources/script/jquery.easyui.min.js"></script>
</head>
<body>

	<c:if test="${!empty userBean.user.id}">
		<c:url var="editUserAction" value="/user/userEdit"></c:url>
	</c:if>
	<c:if test="${empty userBean.user.id}">
		<c:url var="editUserAction" value="/user/userAdd"></c:url>
	</c:if>


	<form:form action="${editUserAction}" modelAttribute="userBean"
		method="post" id="userForm">

		<form:hidden path="nameParam" id="param_name" />
		<form:hidden path="user.salt" />
		<form:hidden path="user.id" />
		<form:hidden path="user.locked" />
		<c:if test="${!empty userBean.user.id}">
			<form:hidden path="user.password" />
		</c:if>

		<table>

			<c:if test="${!empty userBean.user.id}">
			<tr>
				<td class="td-left"><form:label path="user.userName">
						<spring:message text="用户名" />
					</form:label></td>
				<td class="td-right"><form:input path="user.userName"
						id="username" class="easyui-validatebox form-input"
						required="true" missingMessage="名称不能为空 " readonly="true" /></td>
			</tr>
			</c:if>

			<c:if test="${empty userBean.user.id}">
			
				<tr>
					<td class="td-left"><form:label path="user.userName">
						<spring:message text="用户名" />
					</form:label></td>
					<td class="td-right"><form:input path="user.userName"
						id="user_name" class="easyui-validatebox form-input"
						required="true" missingMessage="名称不能为空" /><span id="gradeinfo"></span></td>
				</tr>
			
				<tr>
					<td><form:label path="user.password">
							<spring:message text="密码" />
						</form:label></td>
					<td><form:password path="user.password"
							class="easyui-validatebox form-input" required="true"
							missingMessage="密码不能为空" validType="minLength[6]"/></td>
				</tr>
			</c:if>

			<tr>
				<td><form:label path="selectRoles">
						<spring:message text="角色列表" />
					</form:label></td>
				<td><input type="checkbox" id="allRolesId"> <span>所有角色</span>
					<div class="cbs">
						<form:checkboxes path="selectRoles" items="${userBean.roleList}"
							itemLabel="description" itemValue="id" id="ck"/>
					</div></td>
			</tr>

			<tr>
				<td colspan="2"><c:if test="${!empty userBean.user.id}">
						<input type="button" class="searchField btn btn-primary"
							value="<spring:message text="修改"/>" onclick="editUser()" />
					</c:if> <c:if test="${empty userBean.user.id}">
						<input type="button" class="searchField btn btn-primary"
							value="<spring:message text="添加"/>" onclick="addUser()" />
					</c:if> <input type="button" class="searchField btn btn-primary"
					value="<spring:message text="取消"/>" onclick="cancel()" /></td>
			</tr>
		</table>
	</form:form>

	<script>
		var userIsExist = true;
		function editUser() {
			
			$('#userForm').form('submit',{
				onSubmit:function(){
					return  $(this).form('validate');
				},
				success:function(data){
					var name = $("#param_name").val();
					var queryStr = 'name=' + name ;
					window.location.href='user/userList?' + queryStr;
				}
			});
			
		}

		function addUser() {
			if(!userIsExist){
			$('#userForm').form('submit',{
				onSubmit:function(){
					return  $(this).form('validate');
				},
				success:function(data){
					var name = $("#param_name").val();
					var queryStr = 'name=' + name ;
					window.location.href='user/userList?' + queryStr;
				}
			});
			}
		}

		function cancel() {
			var name = $("#param_name").val();
			var queryStr = 'name=' + name;
			window.location.href = 'user/userList?' + queryStr;
		}
		
		$(document).ready(function() {

				//var sc = $("span:contains('默认角色')").find("input").eq(0);
				
				$("input[name='selectRoles']").each(function(){
					if(!$(this).checked){
						$("#allRolesId").prop("checked",false);
					} 				
				//var sc = $("span:contains('默认角色')").find("input").eq(0);
			
					if($("input[name='selectRoles']").length == $("input[name='selectRoles']:checked").length) {
						$("#allRolesId").prop("checked",true);
					}
			
				}); 
			
				$("#allRolesId").click(function() {
					$("input[name='selectRoles']").prop("checked",this.checked);
					//sc.prop("checked", "checked");
				});
			
				$("input[name='selectRoles']").each(function(){
					 $(this).click( function(){
						if(!$(this).checked){
							$("#allRolesId").prop("checked",false);
							//sc.prop("checked", "checked");
						} 
						
						if($("input[name='selectRoles']").length == $("input[name='selectRoles']:checked").length) {
							$("#allRolesId").prop("checked",true);
							//sc.prop("checked", "checked");
						}
					});
				}); 
				
				
				//sc.prop("checked", "checked");
				//sc.prop("readonly", "readonly");
				
				checkUserIsExist();
				
		});
		
		function checkUserIsExist() {
			$("#user_name").blur(function(){ 
				var para = {};  
				para.username = $(this).val(); 
				$.ajax({  
				    url: '<%=basePath%>'+"/user/checkUserIsExist",  
				    data: para,  
				    type: "POST",  
				    dataType: "json",  
				    success: function (data) {  
				    	if(data.user == "exist"){
				    		$("#gradeinfo").html("<font color='red'> 您输入的用户名已存在！请重新输入！</font>"); 
				    		userIsExist = true;
				    	}else{
				    		$("#gradeinfo").html(""); 
				    		userIsExist = false;
				    	}
				    }  
				});  
			});
		}
		
		$.extend($.fn.validatebox.defaults.rules, {
			minLength: {
				validator: function(value, param){
					return value.length >= param[0];
				},
				message: '密码至少为6位'
		    }
		});
	</script>


</body>
</html>