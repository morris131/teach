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
 * DownloadResourceType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "download_resource_type", catalog = "teach")
public class DownloadResourceType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer downTypeId;
	private String downTypeName;
	private Set<DownloadResource> downloadResources = new HashSet<DownloadResource>(
			0);

	// Constructors

	/** default constructor */
	public DownloadResourceType() {
	}

	/** minimal constructor */
	public DownloadResourceType(String downTypeName) {
		this.downTypeName = downTypeName;
	}

	/** full constructor */
	public DownloadResourceType(String downTypeName,
			Set<DownloadResource> downloadResources) {
		this.downTypeName = downTypeName;
		this.downloadResources = downloadResources;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "down_type_id", unique = true, nullable = false)
	public Integer getDownTypeId() {
		return this.downTypeId;
	}

	public void setDownTypeId(Integer downTypeId) {
		this.downTypeId = downTypeId;
	}

	@Column(name = "down_type_name", nullable = false, length = 50)
	public String getDownTypeName() {
		return this.downTypeName;
	}

	public void setDownTypeName(String downTypeName) {
		this.downTypeName = downTypeName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "downloadResourceType")
	public Set<DownloadResource> getDownloadResources() {
		return this.downloadResources;
	}

	public void setDownloadResources(Set<DownloadResource> downloadResources) {
		this.downloadResources = downloadResources;
	}

}