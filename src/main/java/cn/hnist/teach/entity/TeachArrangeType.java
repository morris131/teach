package cn.hnist.teach.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="teach_arrange_type")
@NamedQuery(name="TeachArrangeType.findAll", query="SELECT t FROM TeachArrangeType t")
public class TeachArrangeType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String name;

	//bi-directional many-to-one association to TeachArrange
	@OneToMany(mappedBy="teachArrangeType",cascade={CascadeType.REMOVE,CascadeType.REFRESH})
	private List<TeachArrange> teachArranges;

	public TeachArrangeType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TeachArrange> getTeachArranges() {
		return this.teachArranges;
	}

	public void setTeachArranges(List<TeachArrange> teachArranges) {
		this.teachArranges = teachArranges;
	}

	public TeachArrange addTeachArrange(TeachArrange teachArrange) {
		getTeachArranges().add(teachArrange);
		teachArrange.setTeachArrangeType(this);

		return teachArrange;
	}

	public TeachArrange removeTeachArrange(TeachArrange teachArrange) {
		getTeachArranges().remove(teachArrange);
		teachArrange.setTeachArrangeType(null);

		return teachArrange;
	}

	@Override
	public String toString() {
		return "TeachArrangeType [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		TeachArrangeType other = (TeachArrangeType) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public TeachArrangeType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}