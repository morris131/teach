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
 * TeacherIntroType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "teacher_intro_type", catalog = "teach")
public class TeacherIntroType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer teaTypeId;
	private String teaTypeName;
	private Set<TeacherIntro> teacherIntros = new HashSet<TeacherIntro>(0);

	// Constructors

	/** default constructor */
	public TeacherIntroType() {
	}

	/** minimal constructor */
	public TeacherIntroType(String teaTypeName) {
		this.teaTypeName = teaTypeName;
	}

	/** full constructor */
	public TeacherIntroType(String teaTypeName, Set<TeacherIntro> teacherIntros) {
		this.teaTypeName = teaTypeName;
		this.teacherIntros = teacherIntros;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tea_type_id", unique = true, nullable = false)
	public Integer getTeaTypeId() {
		return this.teaTypeId;
	}

	public void setTeaTypeId(Integer teaTypeId) {
		this.teaTypeId = teaTypeId;
	}

	@Column(name = "tea_type_name", nullable = false, length = 50)
	public String getTeaTypeName() {
		return this.teaTypeName;
	}

	public void setTeaTypeName(String teaTypeName) {
		this.teaTypeName = teaTypeName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacherIntroType")
	public Set<TeacherIntro> getTeacherIntros() {
		return this.teacherIntros;
	}

	public void setTeacherIntros(Set<TeacherIntro> teacherIntros) {
		this.teacherIntros = teacherIntros;
	}

}