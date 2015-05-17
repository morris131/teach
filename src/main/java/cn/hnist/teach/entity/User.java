package cn.hnist.teach.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String password;

	private String username;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="user_role"
		, joinColumns={
			@JoinColumn(name="user_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="role_id")
			}
		)
	private List<Role> roles;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}