package cn.hnist.teach.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="outstand_student")
public class OutstandStudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; // 编号

	@Lob
	private String content; // 描述

	private Long count; // 点击次数

	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime; // 发布时间

	private String title; // 标题
	
	private String fileName; // 文件名 
	
	@ManyToOne
	@JoinColumn(name="src")
	private ResourceSrc resourceSrc; // 来源

	//bi-directional many-to-one association to OutstandStudentType
	@ManyToOne
	@JoinColumn(name="type")
	private OutstandStudentType outstandStudentType; // 类型

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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ResourceSrc getResourceSrc() {
		return resourceSrc;
	}

	public void setResourceSrc(ResourceSrc resourceSrc) {
		this.resourceSrc = resourceSrc;
	}

	public OutstandStudentType getOutstandStudentType() {
		return this.outstandStudentType;
	}

	public void setOutstandStudentType(OutstandStudentType outstandStudentType) {
		this.outstandStudentType = outstandStudentType;
	}

	@Override
	public String toString() {
		return "OutstandStudent [id=" + id + ", content=" + content
				+ ", count=" + count + ", datetime=" + datetime + ", title="
				+ title + ", fileName=" + fileName + "]";
	}
}