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
 * TeachArrangeType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "teach_arrange_type", catalog = "teach")
public class TeachArrangeType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer teachTypeId;
	private String teachTypeName;
	private Set<TeachArrange> teachArranges = new HashSet<TeachArrange>(0);

	// Constructors

	/** default constructor */
	public TeachArrangeType() {
	}

	/** minimal constructor */
	public TeachArrangeType(String teachTypeName) {
		this.teachTypeName = teachTypeName;
	}

	/** full constructor */
	public TeachArrangeType(String teachTypeName,
			Set<TeachArrange> teachArranges) {
		this.teachTypeName = teachTypeName;
		this.teachArranges = teachArranges;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "teach_type_id", unique = true, nullable = false)
	public Integer getTeachTypeId() {
		return this.teachTypeId;
	}

	public void setTeachTypeId(Integer teachTypeId) {
		this.teachTypeId = teachTypeId;
	}

	@Column(name = "teach_type_name", nullable = false, length = 50)
	public String getTeachTypeName() {
		return this.teachTypeName;
	}

	public void setTeachTypeName(String teachTypeName) {
		this.teachTypeName = teachTypeName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teachArrangeType")
	public Set<TeachArrange> getTeachArranges() {
		return this.teachArranges;
	}

	public void setTeachArranges(Set<TeachArrange> teachArranges) {
		this.teachArranges = teachArranges;
	}

}