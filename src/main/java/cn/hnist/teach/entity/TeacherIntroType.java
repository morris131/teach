package cn.hnist.teach.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="teacher_intro_type")
@NamedQuery(name="TeacherIntroType.findAll", query="SELECT t FROM TeacherIntroType t")
public class TeacherIntroType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String name;

	//bi-directional many-to-one association to TeacherIntro
	@OneToMany(mappedBy="teacherIntroType",cascade=CascadeType.REMOVE)
	private List<TeacherIntro> teacherIntros;

	public TeacherIntroType() {
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

	public List<TeacherIntro> getTeacherIntros() {
		return this.teacherIntros;
	}

	public void setTeacherIntros(List<TeacherIntro> teacherIntros) {
		this.teacherIntros = teacherIntros;
	}

	public TeacherIntro addTeacherIntro(TeacherIntro teacherIntro) {
		getTeacherIntros().add(teacherIntro);
		teacherIntro.setTeacherIntroType(this);

		return teacherIntro;
	}

	public TeacherIntro removeTeacherIntro(TeacherIntro teacherIntro) {
		getTeacherIntros().remove(teacherIntro);
		teacherIntro.setTeacherIntroType(null);

		return teacherIntro;
	}

	@Override
	public String toString() {
		return "TeacherIntroType [id=" + id + ", name=" + name + "]";
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
		TeacherIntroType other = (TeacherIntroType) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public TeacherIntroType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}