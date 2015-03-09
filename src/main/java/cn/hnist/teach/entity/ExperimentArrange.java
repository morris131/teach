package cn.hnist.teach.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ExperimentArrange entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "experiment_arrange", catalog = "teach")
public class ExperimentArrange implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer expId;
	private String expTitle;
	private String expContent;

	// Constructors

	/** default constructor */
	public ExperimentArrange() {
	}

	/** full constructor */
	public ExperimentArrange(String expTitle, String expContent) {
		this.expTitle = expTitle;
		this.expContent = expContent;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "exp_id", unique = true, nullable = false)
	public Integer getExpId() {
		return this.expId;
	}

	public void setExpId(Integer expId) {
		this.expId = expId;
	}

	@Column(name = "exp_title", nullable = false, length = 50)
	public String getExpTitle() {
		return this.expTitle;
	}

	public void setExpTitle(String expTitle) {
		this.expTitle = expTitle;
	}

	@Column(name = "exp_content", nullable = false, length = 65535)
	public String getExpContent() {
		return this.expContent;
	}

	public void setExpContent(String expContent) {
		this.expContent = expContent;
	}

}