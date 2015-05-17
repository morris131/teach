package cn.hnist.teach.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="download_resource")
@NamedQuery(name="DownloadResource.findAll", query="SELECT d FROM DownloadResource d")
public class DownloadResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String content;

	private Long count;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;

	private String title;

	private String name;
	
	private String realName;
	
	@ManyToOne
	@JoinColumn(name="src")
	private ResourceSrc resourceSrc;

	public ResourceSrc getResourceSrc() {
		return resourceSrc;
	}

	public void setResourceSrc(ResourceSrc resourceSrc) {
		this.resourceSrc = resourceSrc;
	}

	//bi-directional many-to-one association to DownloadResourceType
	@ManyToOne
	@JoinColumn(name="type")
	private DownloadResourceType downloadResourceType;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCount() {
		return this.count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public DownloadResourceType getDownloadResourceType() {
		return this.downloadResourceType;
	}

	public void setDownloadResourceType(DownloadResourceType downloadResourceType) {
		this.downloadResourceType = downloadResourceType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Override
	public String toString() {
		return "DownloadResource [id=" + id + ", content=" + content
				+ ", count=" + count + ", datetime=" + datetime + ", title="
				+ title + ", name=" + name + ", realName=" + realName + "]";
	}
	
	
}