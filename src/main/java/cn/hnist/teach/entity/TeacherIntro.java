package cn.hnist.teach.entity;


import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 师资介绍实体类
 */
@Entity
@Table(name = "teacher_intro", catalog = "teach")
public class TeacherIntro implements java.io.Serializable {

	@Override
	public String toString() {
		return "TeacherIntro [teacherId=" + teacherId + ", teacherIntroType="
				+ teacherIntroType + ", teacherTitle=" + teacherTitle
				+ ", teacherContent=" + teacherContent + ", teacherDate="
				+ teacherDate + ", teacherCount=" + teacherCount + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer teacherId;//id
	private TeacherIntroType teacherIntroType;//对应内容实体类
	private String teacherTitle;//标题
	private String teacherContent;//内容
	private Timestamp teacherDate;//发布时间
	private Integer teacherCount;//点击次数

	// Constructors

	/** default constructor */
	public TeacherIntro() {
	}

	/** minimal constructor */
	public TeacherIntro(String teacherTitle, String teacherContent,
			Timestamp teacherDate, Integer teacherCount) {
		this.teacherTitle = teacherTitle;
		this.teacherContent = teacherContent;
		this.teacherDate = teacherDate;
		this.teacherCount = teacherCount;
	}

	/** full constructor */
	public TeacherIntro(TeacherIntroType teacherIntroType, String teacherTitle,
			String teacherContent, Timestamp teacherDate, Integer teacherCount) {
		this.teacherIntroType = teacherIntroType;
		this.teacherTitle = teacherTitle;
		this.teacherContent = teacherContent;
		this.teacherDate = teacherDate;
		this.teacherCount = teacherCount;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "teacher_id", unique = true, nullable = false)
	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_type")
	public TeacherIntroType getTeacherIntroType() {
		return this.teacherIntroType;
	}

	public void setTeacherIntroType(TeacherIntroType teacherIntroType) {
		this.teacherIntroType = teacherIntroType;
	}

	@Column(name = "teacher_title", nullable = false, length = 50)
	public String getTeacherTitle() {
		return this.teacherTitle;
	}

	public void setTeacherTitle(String teacherTitle) {
		this.teacherTitle = teacherTitle;
	}

	@Column(name = "teacher_content", nullable = false, length = 65535)
	public String getTeacherContent() {
		return this.teacherContent;
	}

	public void setTeacherContent(String teacherContent) {
		this.teacherContent = teacherContent;
	}

	@Column(name = "teacher_date", nullable = false, length = 19)
	public Timestamp getTeacherDate() {
		return this.teacherDate;
	}

	public void setTeacherDate(Timestamp teacherDate) {
		this.teacherDate = teacherDate;
	}

	@Column(name = "teacher_count", nullable = false)
	public Integer getTeacherCount() {
		return this.teacherCount;
	}

	public void setTeacherCount(Integer teacherCount) {
		this.teacherCount = teacherCount;
	}

}