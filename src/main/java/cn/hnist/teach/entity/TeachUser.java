package cn.hnist.teach.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TeachUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "teach_user", catalog = "teach")
public class TeachUser implements java.io.Serializable {

	@Override
	public String toString() {
		return "TeachUser [userName=" + userName + ", userPassword="
				+ userPassword + ", userRole=" + userRole + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String userName;
	private String userPassword;
	private String userRole;

	// Constructors

	/** default constructor */
	public TeachUser() {
	}

	/** full constructor */
	public TeachUser(String userName, String userPassword, String userRole) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRole = userRole;
	}

	// Property accessors
	@Id
	@Column(name = "user_name", unique = true, nullable = false, length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_password", nullable = false, length = 50)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "user_role", nullable = false, length = 10)
	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}