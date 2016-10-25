<%@ page pageEncoding="UTF-8"%>
<div class="searchField input-group">
	<span class="input-group-addon"><spring:message text="浏览器版本:"/></span> 
	<form:select id="param_appVersion" path="searchParameter.appVersion" class="form-control">
		<form:option value="" label="所有" />  
	    <form:options items="${searchParameter.versionNameList}" />
	</form:select>
</div>