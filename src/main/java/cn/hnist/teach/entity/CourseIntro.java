package cn.hnist.teach.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 课程简介表
 */
@Entity
@Table(name = "course_intro", catalog = "teach")
public class CourseIntro implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer courseId;//id
	private String courseTitle;//标题
	private String courseContent;//内容

	// Constructors

	/** default constructor */
	public CourseIntro() {
	}

	/** full constructor */
	public CourseIntro(String courseTitle, String courseContent) {
		this.courseTitle = courseTitle;
		this.courseContent = courseContent;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "course_id", unique = true, nullable = false)
	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@Column(name = "course_title", nullable = false, length = 50)
	public String getCourseTitle() {
		return this.courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	@Column(name = "course_content", nullable = false, length = 65535)
	public String getCourseContent() {
		return this.courseContent;
	}

	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}

	@Override
	public String toString() {
		return "CourseIntro [courseId=" + courseId + ", courseTitle="
				+ courseTitle + ", courseContent=" + courseContent + "]";
	}
	
	

}