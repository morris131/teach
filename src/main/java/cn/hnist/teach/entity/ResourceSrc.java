package cn.hnist.teach.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ResourceSrc {
	
	@Id
	@GeneratedValue
	private Short id;
	
	private String name;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ResourceSrc [id=" + id + ", name=" + name + "]";
	}
}



