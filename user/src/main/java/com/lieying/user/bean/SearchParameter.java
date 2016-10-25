package com.lieying.user.bean;

import java.util.List;
import java.util.Map;

public class SearchParameter {
	
	private Integer clientType;
	
	private String appVersion;
	
	private String channelName;
	
	private String name;
	
	private Integer type;
	
	private List<String> channelNameList; 
	
	private List<String> versionNameList;
	
	private List<Integer> clientTypeList;
	
	private Map<Integer,String> clientTypeMap;
	
	private String returnStr;
	
	private Integer status;
	
	public Integer getClientType() {
		return clientType;
	}

	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<String> getChannelNameList() {
		return channelNameList;
	}

	public void setChannelNameList(List<String> channelNameList) {
		this.channelNameList = channelNameList;
	}

	public List<String> getVersionNameList() {
		return versionNameList;
	}

	public void setVersionNameList(List<String> versionNameList) {
		this.versionNameList = versionNameList;
	}

	public String getReturnStr() {
		return returnStr;
	}
	

	public void setReturnStr(String returnStr) {
		this.returnStr = returnStr;
	}

	public List<Integer> getClientTypeList() {
		return clientTypeList;
	}
	

	public void setClientTypeList(List<Integer> clientTypeList) {
		this.clientTypeList = clientTypeList;
	}

	@Override
	public String toString() {
		return "SearchParameter [clientType=" + clientType + ", appVersion=" + appVersion + ", channelName="
				+ channelName + ", name=" + name + ", type=" + type + ", channelNameList=" + channelNameList
				+ ", versionNameList=" + versionNameList + ", clientTypeList=" + clientTypeList + ", returnStr="
				+ returnStr + "]";
	}

	public Map<Integer,String> getClientTypeMap() {
		return clientTypeMap;
	}

	public void setClientTypeMap(Map<Integer,String> clientTypeMap) {
		this.clientTypeMap = clientTypeMap;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
