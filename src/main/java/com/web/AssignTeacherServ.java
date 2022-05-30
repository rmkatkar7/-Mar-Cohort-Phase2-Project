package com.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Subject;
import com.bean.SubjectTeacherClass;
import com.bean.Teacher;
import com.dao.AssignTeachersDao;
import com.dao.SubjectDao;
import com.dao.TeacherDao;


@WebServlet(urlPatterns = {"/teacher-subject","/stcinsert","/stcdelete","/stclist",})
public class AssignTeacherServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private AssignTeachersDao assignTeacherDao=null;
    
    public AssignTeacherServ() {
        super();
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		assignTeacherDao = new AssignTeachersDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String action = request.getServletPath();
		System.out.println("Servlet path "+action);

		try {
			switch (action) {
			case "/stcinsert":
				assignTeachers(request, response);
				break;
			case "/stcdelete":
				deleteAssignedTeacher(request, response);
				break;
			default:
				listClassReportById(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void assignTeachers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		SubjectTeacherClass subjectTeacherClass = new SubjectTeacherClass();
		subjectTeacherClass.setClassId(Integer.parseInt((request.getParameter("cid"))));
//		subjectTeacherClass.setSubjectId(Integer.parseInt((request.getParameter("sid"))));
//		subjectTeacherClass.setTeacherId(Integer.parseInt((request.getParameter("tid"))));
		subjectTeacherClass.setClassName(request.getParameter("cname"));
		subjectTeacherClass.setSubjectName(request.getParameter("subject"));
		subjectTeacherClass.setTeacherFname(request.getParameter("teacher"));
		//subjectTeacherClass.setTeacherLname(request.getParameter("t_lname"));
		System.out.println("Inside Insert");
		assignTeacherDao.AssignTeacher(subjectTeacherClass);
		listClassReportById(request, response);
		
	}
	
	private void listClassReportById(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		TeacherDao teacherDao = new TeacherDao();
		SubjectDao subjectDao = new SubjectDao();
		System.out.println("Inside List ");
		System.out.println("Cid inside list +"+request.getParameter("cid"));
		List<SubjectTeacherClass> listClassReport = assignTeacherDao.classReportByID(Integer.parseInt(request.getParameter("cid")));
		request.setAttribute("listClassReport", listClassReport);
		List<Teacher> listTeacher = teacherDao.showAllTeachers();
		request.setAttribute("listTeacher", listTeacher);
		if(listClassReport.size()>0)
			request.setAttribute("className", listClassReport.get(0).getClassName());
		List<Subject> listSubject = subjectDao.showAllSubjects();
		request.setAttribute("listSubject", listSubject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assign-teacher.jsp");
		dispatcher.forward(request, response);
	}
	
	private void deleteAssignedTeacher(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		SubjectTeacherClass subjectTeacherClass = new SubjectTeacherClass();
		subjectTeacherClass.setId(id);
		assignTeacherDao.DeleteAssignTeacher(subjectTeacherClass);
		listClassReportById(request, response);
	}
	
	

}
