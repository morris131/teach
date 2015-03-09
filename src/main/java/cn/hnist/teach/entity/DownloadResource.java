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
 * DownloadResource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "download_resource", catalog = "teach")
public class DownloadResource implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer downId;
	private DownloadResourceType downloadResourceType;
	private String downTitle;
	private String downContent;
	private Timestamp downDate;
	private Integer downCount;

	// Constructors

	/** default constructor */
	public DownloadResource() {
	}

	/** minimal constructor */
	public DownloadResource(String downTitle, String downContent,
			Timestamp downDate, Integer downCount) {
		this.downTitle = downTitle;
		this.downContent = downContent;
		this.downDate = downDate;
		this.downCount = downCount;
	}

	/** full constructor */
	public DownloadResource(DownloadResourceType downloadResourceType,
			String downTitle, String downContent, Timestamp downDate,
			Integer downCount) {
		this.downloadResourceType = downloadResourceType;
		this.downTitle = downTitle;
		this.downContent = downContent;
		this.downDate = downDate;
		this.downCount = downCount;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "down_id", unique = true, nullable = false)
	public Integer getDownId() {
		return this.downId;
	}

	public void setDownId(Integer downId) {
		this.downId = downId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "down_type")
	public DownloadResourceType getDownloadResourceType() {
		return this.downloadResourceType;
	}

	public void setDownloadResourceType(
			DownloadResourceType downloadResourceType) {
		this.downloadResourceType = downloadResourceType;
	}

	@Column(name = "down_title", nullable = false, length = 50)
	public String getDownTitle() {
		return this.downTitle;
	}

	public void setDownTitle(String downTitle) {
		this.downTitle = downTitle;
	}

	@Column(name = "down_content", nullable = false, length = 65535)
	public String getDownContent() {
		return this.downContent;
	}

	public void setDownContent(String downContent) {
		this.downContent = downContent;
	}

	@Column(name = "down_date", nullable = false, length = 19)
	public Timestamp getDownDate() {
		return this.downDate;
	}

	public void setDownDate(Timestamp downDate) {
		this.downDate = downDate;
	}

	@Column(name = "down_count", nullable = false)
	public Integer getDownCount() {
		return this.downCount;
	}

	public void setDownCount(Integer downCount) {
		this.downCount = downCount;
	}

}