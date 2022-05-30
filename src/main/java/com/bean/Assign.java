package com.bean;

public class Assign {

	private String className;
	private int classId;
	private String teacherFName;
	private String teacherLName;
	public String getTeacherFName() {
		return teacherFName;
	}
	public void setTeacherFName(String teacherFName) {
		this.teacherFName = teacherFName;
	}
	public String getTeacherLName() {
		return teacherLName;
	}
	public void setTeacherLName(String teacherLName) {
		this.teacherLName = teacherLName;
	}
	private int TeacherId;
	private String subjectName;
	private int subjectId;
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	public int getTeacherId() {
		return TeacherId;
	}
	public void setTeacherId(int teacherId) {
		TeacherId = teacherId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	@Override
	public String toString() {
		return "Assign [className=" + className + ", classId=" + classId + ", teacherName=" + teacherFName+teacherLName
				+ ", TeacherId=" + TeacherId + ", subjectName=" + subjectName + ", subjectId=" + subjectId + "]";
	}
}
