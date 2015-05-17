package cn.hnist.teach.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="teach_arrange")
@NamedQuery(name="TeachArrange.findAll", query="SELECT t FROM TeachArrange t")
public class TeachArrange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@Lob
	private String content;

	private Long count;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;

	private String title;

	//bi-directional many-to-one association to TeachArrangeType
	@ManyToOne
	@JoinColumn(name="type")
	private TeachArrangeType teachArrangeType;

	public TeachArrange() {
	}

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

	public long getCount() {
		return this.count;
	}

	public void setCount(long count) {
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

	public TeachArrangeType getTeachArrangeType() {
		return this.teachArrangeType;
	}

	public void setTeachArrangeType(TeachArrangeType teachArrangeType) {
		this.teachArrangeType = teachArrangeType;
	}

	@Override
	public String toString() {
		return "TeachArrange [id=" + id + ", content=" + content + ", count="
				+ count + ", datetime=" + datetime + ", title=" + title + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result
				+ ((datetime == null) ? 0 : datetime.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeachArrange other = (TeachArrange) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (datetime == null) {
			if (other.datetime != null)
				return false;
		} else if (!datetime.equals(other.datetime))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public TeachArrange(int id, String content, long count,
			Date datetime, String title) {
		super();
		this.id = id;
		this.content = content;
		this.count = count;
		this.datetime = datetime;
		this.title = title;
	}
}