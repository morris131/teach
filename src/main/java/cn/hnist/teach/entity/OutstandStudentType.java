package cn.hnist.teach.entity;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * OutstandStudentType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "outstand_student_type", catalog = "teach")
public class OutstandStudentType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer stuTypeId;
	private String stuTypeName;
	private Set<OutstandStudent> outstandStudents = new HashSet<OutstandStudent>(
			0);

	// Constructors

	/** default constructor */
	public OutstandStudentType() {
	}

	/** minimal constructor */
	public OutstandStudentType(String stuTypeName) {
		this.stuTypeName = stuTypeName;
	}

	/** full constructor */
	public OutstandStudentType(String stuTypeName,
			Set<OutstandStudent> outstandStudents) {
		this.stuTypeName = stuTypeName;
		this.outstandStudents = outstandStudents;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "stu_type_id", unique = true, nullable = false)
	public Integer getStuTypeId() {
		return this.stuTypeId;
	}

	public void setStuTypeId(Integer stuTypeId) {
		this.stuTypeId = stuTypeId;
	}

	@Column(name = "stu_type_name", nullable = false, length = 50)
	public String getStuTypeName() {
		return this.stuTypeName;
	}

	public void setStuTypeName(String stuTypeName) {
		this.stuTypeName = stuTypeName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "outstandStudentType")
	public Set<OutstandStudent> getOutstandStudents() {
		return this.outstandStudents;
	}

	public void setOutstandStudents(Set<OutstandStudent> outstandStudents) {
		this.outstandStudents = outstandStudents;
	}

}