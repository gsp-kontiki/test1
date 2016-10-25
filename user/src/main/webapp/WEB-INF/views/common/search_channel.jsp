<%@ page pageEncoding="UTF-8"%>
<div class="searchField input-group">
	<span class="input-group-addon"><spring:message text="渠道:"/></span> 
	<form:select path="searchParameter.channelName"  id="param_channelName" class="form-control">
		 <form:option value="" label="所有" />  
	     <form:options items="${searchParameter.channelNameList}" />
	</form:select>
</div>