package com.bean;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;



@Entity

@Table (name = "student")
@NamedNativeQueries({
    @NamedNativeQuery(name = "GET_STUDENT_BY_ID", query = "select * from student where id=:id"),
    @NamedNativeQuery(name = "GET_ALL_STUDENTS", query = "select * from student", resultClass = Student.class)
})
public class Student {
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob + ", class_map="
				+ class_map + ", address=" + address + ", phone=" + phone + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column (name = "fname")
	private String fname;
	
	@Column (name = "lname")
	private String lname;
	
	@Column (name = "dob")
	private LocalDate dob;
	
	@ManyToOne(targetEntity = ClassTable.class,cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "class_id")
	private ClassTable class_map;
	
	@Embedded
	private Address address;
	
	@Column (name = "phone")
	private String phone;

	public Student() {
		super();
	}
	public ClassTable getClass_map() {
		return class_map;
	}


	public void setClass_map(ClassTable class_map) {
		this.class_map = class_map;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
