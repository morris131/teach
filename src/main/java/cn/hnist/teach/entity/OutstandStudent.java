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
 * OutstandStudent entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "outstand_student", catalog = "teach")
public class OutstandStudent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer stuId;
	private OutstandStudentType outstandStudentType;
	private String stuTitle;
	private String stuContent;
	private Timestamp stuDate;
	private Integer stuCount;

	// Constructors

	/** default constructor */
	public OutstandStudent() {
	}

	/** minimal constructor */
	public OutstandStudent(String stuTitle, String stuContent,
			Timestamp stuDate, Integer stuCount) {
		this.stuTitle = stuTitle;
		this.stuContent = stuContent;
		this.stuDate = stuDate;
		this.stuCount = stuCount;
	}

	/** full constructor */
	public OutstandStudent(OutstandStudentType outstandStudentType,
			String stuTitle, String stuContent, Timestamp stuDate,
			Integer stuCount) {
		this.outstandStudentType = outstandStudentType;
		this.stuTitle = stuTitle;
		this.stuContent = stuContent;
		this.stuDate = stuDate;
		this.stuCount = stuCount;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "stu_id", unique = true, nullable = false)
	public Integer getStuId() {
		return this.stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stu_type")
	public OutstandStudentType getOutstandStudentType() {
		return this.outstandStudentType;
	}

	public void setOutstandStudentType(OutstandStudentType outstandStudentType) {
		this.outstandStudentType = outstandStudentType;
	}

	@Column(name = "stu_title", nullable = false, length = 50)
	public String getStuTitle() {
		return this.stuTitle;
	}

	public void setStuTitle(String stuTitle) {
		this.stuTitle = stuTitle;
	}

	@Column(name = "stu_content", nullable = false, length = 65535)
	public String getStuContent() {
		return this.stuContent;
	}

	public void setStuContent(String stuContent) {
		this.stuContent = stuContent;
	}

	@Column(name = "stu_date", nullable = false, length = 19)
	public Timestamp getStuDate() {
		return this.stuDate;
	}

	public void setStuDate(Timestamp stuDate) {
		this.stuDate = stuDate;
	}

	@Column(name = "stu_count", nullable = false)
	public Integer getStuCount() {
		return this.stuCount;
	}

	public void setStuCount(Integer stuCount) {
		this.stuCount = stuCount;
	}

}