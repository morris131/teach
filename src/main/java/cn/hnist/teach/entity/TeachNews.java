package cn.hnist.teach.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="teach_news")
public class TeachNews implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@Lob
	private String content;

	private Long count;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;

	@ManyToOne
	@JoinColumn(name="src")
	private ResourceSrc resourceSrc;

	private String title;

	private short type;

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

	public short getType() {
		return this.type;
	}

	public void setType(short type) {
		this.type = type;
	}
	
	public ResourceSrc getResourceSrc() {
		return resourceSrc;
	}

	public void setResourceSrc(ResourceSrc resourceSrc) {
		this.resourceSrc = resourceSrc;
	}

	@Override
	public String toString() {
		return "TeachNews [id=" + id + ", content=" + content + ", count="
				+ count + ", datetime=" + datetime + ", title=" + title
				+ ", type=" + type + "]";
	}
}