<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp" %> 

<html>
<head> 
	<title>省流量开关</title>
	<style type="text/css">
	</style>
	
	<link href="resources/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
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

			<c:if test="${!empty switchBean.swit.id}">
				<c:url var="editSwitchAction" value="/switch/switchEdit"></c:url>
			</c:if>
			<c:if test="${empty switchBean.swit.id}">
				<c:url var="editSwitchAction" value="/switch/switchAdd"></c:url>
			</c:if>
			

<form:form action="${editSwitchAction}" modelAttribute="switchBean" method="post" enctype="multipart/form-data" id="switchForm">

<form:hidden path="nameParam" id="param_name"/>
<form:hidden path="channelNameParam" id="param_ChannelName"/>
<form:hidden path="appVersionParam" id="param_appVersion"/>
<form:hidden path="clientTypeParam" id="param_clientType"/>
<form:hidden path="appVersionParam" id="param_appVersion"/>
<form:hidden path="clientTypeParam" id="param_clientType"/>

<table>


	<c:if test="${!empty switchBean.swit.id}">
	<tr>
		<td>
			<form:label path="swit.id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="swit.id" readonly="true" size="8"  disabled="true" class="form-input"/>
			<form:hidden path="swit.id"  id="switchId"/>
		</td> 
	</tr>
	</c:if>
	
	
	<form:hidden path="swit.createDate" />
	<form:hidden path="swit.updateDate" />
	<form:hidden path="swit.clientType" />
	
	<tr>
		<td class="td-left">
			<form:label path="swit.name">
				<spring:message text="名称"/>
			</form:label>
		</td>
		<td class="td-right">
			<c:choose>
				<c:when test="${empty switchBean.swit.id}">
					<form:select  path="swit.name" id="switch_name" class="form-control">
					<form:option value="main_switch"  class="form-control-block">总开关</form:option>
					<form:option value="webeye_switch" class="form-control-block">网眼广告开关</form:option> 
				</form:select>
				</c:when>
				<c:otherwise>
					<c:if test="${switchBean.swit.name eq 'main_switch'}">
						<span>总开关</span>
					</c:if>
					<c:if test="${switchBean.swit.name eq 'webeye_switch'}">
						<span>网眼广告开关</span>
					</c:if>
					
					<form:hidden path="swit.name" id="switch_name"/>
				</c:otherwise>
			</c:choose>
			
			
		</td> 
	</tr>
	
	
	

	<tr>
		<td>
			<form:label path="swit.appVersion">
				<spring:message text="接口数据版本"/>
			</form:label>
		</td>
		<td>
			<c:choose>
				<c:when test="${empty switchBean.swit.id}">
				<input type="checkbox" id="allVersionCheckId"> <span>所有版本</span>
				<div class="cbs">
				<form:checkboxes  path="selectVersion"  items="${switchBean.versionList}" /> 
				</div> 
			</c:when>
			<c:otherwise>
				<form:input path="swit.appVersion" readonly="true"/>
			</c:otherwise>
			</c:choose>
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="swit.channelName">
				<spring:message text="渠道"/>
			</form:label>
		</td>
		<td>
			<c:choose>
				<c:when test="${empty switchBean.swit.id}">
				<input type="checkbox" id="allChannelId" ><span>所有渠道</span>
				<div class="cbs">
				<form:checkboxes  path="selectChannel"  items="${switchBean.channelList}" />  
				</div>
			</c:when>
			<c:otherwise>
				<form:input path="swit.channelName" readonly="true"/>
			</c:otherwise>
			</c:choose>
			
		</td>
	</tr>
	
<!-- 	<tr> -->
<!-- 		<td> -->
<%-- 			<form:label path="swit.clientType"> --%>
<%-- 				<spring:message text="客户端类型"/> --%>
<%-- 			</form:label> --%>
<!-- 		</td> -->
<!-- 		<td> -->
<%-- 			<c:choose> --%>
<%-- 				<c:when test="${empty switchBean.swit.id}"> --%>
<!-- 				<input type="checkbox" id="allClientType" ><span>所有客户端</span> -->
<!-- 				<div class="cbs"> -->
<%-- 				<form:checkboxes  path="selectClientType"  items="${switchBean.clientTypeMap}" />  --%>
<!-- 				</div>  -->
<%-- 			</c:when> --%>
<%-- 			<c:otherwise> --%>
<%-- 				<form:input path="swit.clientType" readonly="true"/> --%>
<%-- 			</c:otherwise> --%>
<%-- 			</c:choose> --%>
			
<!-- 		</td> -->
<!-- 	</tr> -->
	
	
	<tr>
		<td>
			<form:label path="swit.status">
				<spring:message text="开关"/>
			</form:label>
		</td>
		<td>
		<form:select  path="swit.status" items="${switchBean.statusMap}" class="form-control"></form:select>
<%-- 			<form:input path="swit.status" id="switch_status"/> --%>
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="swit.description">
				<spring:message text="描述"/>
			</form:label>
		</td>
		<td>
			<form:input path="swit.description" />
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty switchBean.swit.id}">
				<input type="button" class="searchField btn btn-primary"
					value="<spring:message text="修改"/>" onclick="editSwit()"/>
			</c:if>
			<c:if test="${empty switchBean.swit.id}">
				<input type="button" class="searchField btn btn-primary"
					value="<spring:message text="添加"/>" onclick="addSwit()"/>
			</c:if>
			<input type="button" class="searchField btn btn-primary"
					value="<spring:message text="取消"/>" onclick="cancel()"/>
		</td>
	</tr>
</table>	
</form:form>

<script>
function editSwit(){
	var valid = isValid();
	if(valid) {
		$("#switchForm").submit();
	}
}

function addSwit(){
	var valid = isValid();
	if(valid) {
		$("#switchForm").submit();
	}
}

function isValid() {
	var id = $("#switchId").val();
	if(typeof(id) == "undefined" || id == null) {
		
		
		var hasCheckVersion = false;
		 $("input[name='selectVersion']:checked").each(function(){
			 hasCheckVersion = true;
		}); 
		 if(!hasCheckVersion && $("#param_clientType") == 0) {
			alert("请选择版本!");
			return false;
		} 
		
		var hasCheckChannel = false;
		 $("input[name='selectChannel']:checked").each(function(){
			 hasCheckChannel = true;
		}); 
		 if(!hasCheckChannel) {
			alert("请选择发送渠道!");
			return false;
		} 
		 
// 		 var hasCheckClientType = false;
// 		 $("input[name='selectClientType']:checked").each(function(){
// 			 hasCheckClientType = true;
// 		}); 
// 		 if(!hasCheckClientType) {
// 			alert("请选择客户端类型!");
// 			return false;
// 		} 
	}
	
	var name = $.trim($("#switch_name").val());
	if (reg_NULL(name)) {
		alertSelectFocus("switch_name", "名称不能为空!");
		return false;
	}
	return true;
}


function cancel(){
	var clientType = $("#param_clientType").val();
	var name = $("#param_name").val();
	var channelName = $("#param_ChannelName").val();
	var appVersion = $("#param_appVersion").val();
	var queryStr = 'clientType=' + clientType + '&name=' + name + '&channelName=' + channelName + '&appVersion=' + appVersion;
	window.location.href='switch/switchList?' + queryStr;
}


$(document).ready(function() {
	var id = $("#switchId").val();
	if(typeof(id) == "undefined" || id == null) {
		
		$("#allVersionCheckId").click( function() {
			$("input[name='selectVersion']").prop("checked",this.checked);
		});
		$("#allChannelId").click(function() {
			$("input[name='selectChannel']").prop("checked",this.checked);
		});
		$("#allClientType").click(function() {
			$("input[name='selectClientType']").prop("checked",this.checked);
		});
		
		$("input[name='selectClientType']").each(function(){
			 $(this).click( function(){
				if(!$(this).checked){
					$("#allClientType").prop("checked",false);
				} 
				
				if($("input[name='selectClientType']").length == $("input[name='selectClientType']:checked").length) {
					$("#allClientType").prop("checked",true);
				}
				
			});
		}); 
		
	
		$("input[name='selectVersion']").each(function(){
			 $(this).click( function(){
				if(!$(this).checked){
					$("#allVersionCheckId").prop("checked",false);
				} 
				
				if($("input[name='selectVersion']").length == $("input[name='selectVersion']:checked").length) {
					$("#allVersionCheckId").prop("checked",true);
				}
				
			});
		}); 
		
		$("input[name='selectChannel']").each(function(){
			 $(this).click( function(){
				if(!$(this).checked){
					$("#allChannelId").prop("checked",false);
				} 
				
				if($("input[name='selectChannel']").length == $("input[name='selectChannel']:checked").length) {
					$("#allChannelId").prop("checked",true);
				}
			});
		}); 
	}
});

</script>


</body>
</html>