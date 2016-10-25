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
<title>省流量开关</title>
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
		<%@ include file="/WEB-INF/views/common/search_button.jsp"%>
	<table>
		<tr>
		<td class="td-left">
		<label>client_id</label>
		</td>
		<td class="td-right">
			<input type="text" id="client_id" value="c1ebe466-1cdc-4bd3-ab69-77c3561b9dee" />
		</td> 
		</tr>
		<tr>
		<td class="td-left">
			<label>client_secret</label>
		</td>
		<td class="td-right">
			<input type="text" id="client_secret" value="d8346ea2-6017-43ed-ad68-19c0f971738b"/>
		</td> 
		</tr>
		<tr>
		<td class="td-left">
			<label>code</label>
		</td>
		<td class="td-right">
			<input type="text" id="code" value="33dc94c7dd865ea558a9fb73a7f3e6bb"/>
		</td> 
		</tr>
	</table>
	</div>

	<script>
		function search() {
			loadDataTable();
		}
		
		function loadDataTable(){
			para = {};  
			para.client_id = $("#client_id").val();
			para.client_secret = $("#client_secret").val();
			para.grant_type = "authorization_code";
			para.redirect_uri = "http://localhost:8080/user/login";
			para.code = $("#code").val();
			$.ajax({  
			    url: '<%=basePath%>'+"/accessToken",  
			    data: para,  
			    type: "POST",  
			    dataType: "json",  
			    success: function (data) {  
					alert(data.access_token);
			    }  
			}); 
		}
	</script>
</body>
</html>