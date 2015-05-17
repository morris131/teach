package cn.hnist.teach.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="teacher_intro")
public class TeacherIntro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String content;

	private Long count;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;

	private String title;

	//bi-directional many-to-one association to TeacherIntroType
	@ManyToOne
	@JoinColumn(name="type")
	private TeacherIntroType teacherIntroType;

	public TeacherIntro() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCount() {
		return this.count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TeacherIntroType getTeacherIntroType() {
		return this.teacherIntroType;
	}

	public void setTeacherIntroType(TeacherIntroType teacherIntroType) {
		this.teacherIntroType = teacherIntroType;
	}

	@Override
	public String toString() {
		return "TeacherIntro [id=" + id + ", content=" + content + ", count="
				+ count + ", datetime=" + datetime + ", title=" + title + "]";
	}
}