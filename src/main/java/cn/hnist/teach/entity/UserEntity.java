package cn.hnist.teach.entity;

import java.io.Serializable;


public class UserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Integer access;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAccess() {
		return access;
	}
	public void setAccess(Integer access) {
		this.access = access;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", access=" + access + "]";
	}

	

}


