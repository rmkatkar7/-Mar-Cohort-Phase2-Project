package com.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

	@Entity

	@Table (name = "teacher")
	@NamedNativeQuery(name = "GET_ALL_TEACHERS", query = "select * from teacher", resultClass = Teacher.class)
	public class Teacher {
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
		
		
		@Column (name = "phone")
		private String phone;

		@Embedded
		private Address address;
		
		@Column(name = "designation")
		private String designation;
		
		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
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

		public Teacher(int id, String fname, String lname, LocalDate dob, Address address, String phone) {
			super();
			this.id = id;
			this.fname = fname;
			this.lname = lname;
			this.dob = dob;
			this.address = address;
			this.phone = phone;
		}

		@Override
		public String toString() {
			return "Teacher [id=" + id + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob + ", address="
					+ address + ", phone=" + phone + "]";
		}

		public Teacher() {
			super();
		}

}
