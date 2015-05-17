package cn.hnist.teach.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="outstand_student_type")
public class OutstandStudentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Short id; //编号

	private String name; //类型名

	//bi-directional many-to-one association to OutstandStudent
	@OneToMany(mappedBy="outstandStudentType",cascade=CascadeType.REMOVE)
	private List<OutstandStudent> outstandStudents;

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<OutstandStudent> getOutstandStudents() {
		return this.outstandStudents;
	}

	public void setOutstandStudents(List<OutstandStudent> outstandStudents) {
		this.outstandStudents = outstandStudents;
	}

	public OutstandStudent addOutstandStudent(OutstandStudent outstandStudent) {
		getOutstandStudents().add(outstandStudent);
		outstandStudent.setOutstandStudentType(this);

		return outstandStudent;
	}

	public OutstandStudent removeOutstandStudent(OutstandStudent outstandStudent) {
		getOutstandStudents().remove(outstandStudent);
		outstandStudent.setOutstandStudentType(null);

		return outstandStudent;
	}

	@Override
	public String toString() {
		return "OutstandStudentType [id=" + id + ", name=" + name + "]";
	}
}