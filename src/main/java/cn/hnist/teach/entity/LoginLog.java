package cn.hnist.teach.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="login_log")
public class LoginLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String browser;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;

	private String ip;

	private String name;

	public LoginLog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrowser() {
		return this.browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}