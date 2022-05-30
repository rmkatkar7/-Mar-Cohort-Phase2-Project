package com.bean;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "class")
@NamedNativeQuery(name = "GET_ALL_CLASSES", query = "select * from class", resultClass = ClassTable.class)
public class ClassTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "cid")
	private int cid;
	
	@Column (name = "class_name")
	private String class_name;
	
	/** orphan removal deletes the records whose foreign key got deleted*/

	@OneToMany(targetEntity = com.bean.Student.class,mappedBy = "class_map")
	
	private Set<Student> students = new HashSet<Student>();


	
	public void addStudent(Student student) {
		this.students.add(student);
		student.setClass_map(this);
		
	}
	

	public void removeStudent(Student student) {
		this.students.remove(student);
		student.setClass_map(null);
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
	
}
