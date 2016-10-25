package com.lieying.user.bean;


import com.lieying.user.entity.SysUser;

public class UserBean {
	
	private SysUser user;
	
	private String nameParam;
	
	private String password;
	
	private String retryPassword;
	
	private String oldPassword;
	
	public String getNameParam() {
		return nameParam;
	}
	

	public void setNameParam(String nameParam) {
		this.nameParam = nameParam;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRetryPassword() {
		return retryPassword;
	}
	
	public void setRetryPassword(String retryPassword) {
		this.retryPassword = retryPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}


	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public SysUser getUser() {
		return user;
	}


	public void setUser(SysUser user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "UserBean [user=" + user + ", nameParam=" + nameParam + ", password=" + password + ", retryPassword="
				+ retryPassword + ", oldPassword=" + oldPassword + "]";
	}



}
