package cn.hnist.teach.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String email;

	private String grade;

	private String tel;

	private String title;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String content;

	private short isValid;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public short getIsValid() {
		return isValid;
	}

	public void setIsValid(short isValid) {
		this.isValid = isValid;
	}

	@Column(nullable = true)
	private String reply;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Message() {
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", email=" + email + ", grade=" + grade
				+ ", tel=" + tel + ", title=" + title + ", name=" + name
				+ ", content=" + content + ", isValid=" + isValid
				+ ", datetime=" + datetime + ", reply=" + reply + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((datetime == null) ? 0 : datetime.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + isValid;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reply == null) ? 0 : reply.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (datetime == null) {
			if (other.datetime != null)
				return false;
		} else if (!datetime.equals(other.datetime))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isValid != other.isValid)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reply == null) {
			if (other.reply != null)
				return false;
		} else if (!reply.equals(other.reply))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public Message(Integer id, String email, String grade, String tel,
			String title, String name, String content, short isValid,
			Date datetime, String reply) {
		super();
		this.id = id;
		this.email = email;
		this.grade = grade;
		this.tel = tel;
		this.title = title;
		this.name = name;
		this.content = content;
		this.isValid = isValid;
		this.datetime = datetime;
		this.reply = reply;
	}


}
