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
 * TeachArrange entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "teach_arrange", catalog = "teach")
public class TeachArrange implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer teachId;
	private TeachArrangeType teachArrangeType;
	private String teachTitle;
	private String teachContent;
	private Timestamp teachDate;
	private Integer teachCount;

	// Constructors

	/** default constructor */
	public TeachArrange() {
	}

	/** minimal constructor */
	public TeachArrange(String teachTitle, String teachContent,
			Timestamp teachDate, Integer teachCount) {
		this.teachTitle = teachTitle;
		this.teachContent = teachContent;
		this.teachDate = teachDate;
		this.teachCount = teachCount;
	}

	/** full constructor */
	public TeachArrange(TeachArrangeType teachArrangeType, String teachTitle,
			String teachContent, Timestamp teachDate, Integer teachCount) {
		this.teachArrangeType = teachArrangeType;
		this.teachTitle = teachTitle;
		this.teachContent = teachContent;
		this.teachDate = teachDate;
		this.teachCount = teachCount;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "teach_id", unique = true, nullable = false)
	public Integer getTeachId() {
		return this.teachId;
	}

	public void setTeachId(Integer teachId) {
		this.teachId = teachId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teach_type")
	public TeachArrangeType getTeachArrangeType() {
		return this.teachArrangeType;
	}

	public void setTeachArrangeType(TeachArrangeType teachArrangeType) {
		this.teachArrangeType = teachArrangeType;
	}

	@Column(name = "teach_title", nullable = false, length = 50)
	public String getTeachTitle() {
		return this.teachTitle;
	}

	public void setTeachTitle(String teachTitle) {
		this.teachTitle = teachTitle;
	}

	@Column(name = "teach_content", nullable = false, length = 65535)
	public String getTeachContent() {
		return this.teachContent;
	}

	public void setTeachContent(String teachContent) {
		this.teachContent = teachContent;
	}

	@Column(name = "teach_date", nullable = false, length = 19)
	public Timestamp getTeachDate() {
		return this.teachDate;
	}

	public void setTeachDate(Timestamp teachDate) {
		this.teachDate = teachDate;
	}

	@Column(name = "teach_count", nullable = false)
	public Integer getTeachCount() {
		return this.teachCount;
	}

	public void setTeachCount(Integer teachCount) {
		this.teachCount = teachCount;
	}

}