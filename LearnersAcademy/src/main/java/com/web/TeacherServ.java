package com.web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Address;
import com.bean.Teacher;
import com.dao.TeacherDao;

/**
 * Servlet implementation class TeacherServ
 */

@WebServlet(urlPatterns = {"/tnew","/tedit","/tinsert","/tdelete","/tupdate","/tlist","/teacher-list"})
public class TeacherServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TeacherDao teacherDao;
  
    public TeacherServ() {
        super();
        
    }
    @Override
    	public void init() throws ServletException {
    		teacherDao = new TeacherDao();
    	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("Servlet path "+action);

		try {
			switch (action) {
			case "/tnew":
				showNewForm(request, response);
				break;
			case "/tinsert":
				insertTeacher(request, response);
				break;
			case "/tdelete":
				deleteTeacher(request, response);
				break;
			case "/tedit":
				showEditForm(request, response);
				break;
			case "/tupdate":
				updateTeacher(request, response);
				break;
			default:
				listTeacher(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<Teacher> listTeacher = teacherDao.showAllTeachers();
		request.setAttribute("listTeacher", listTeacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Teacher existingTeacher = teacherDao.selectTeacher(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher.jsp");
		request.setAttribute("teacher", existingTeacher);
		dispatcher.forward(request, response);

	}

	private void insertTeacher(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,NumberFormatException {
		Teacher teacher = new Teacher();
		Address address = new Address();
		teacher.setFname(request.getParameter("fname"));
		teacher.setLname(request.getParameter("lname"));
		teacher.setDob(LocalDate.parse(request.getParameter("dob")));
		teacher.setPhone(request.getParameter("phone"));
		teacher.setDesignation(request.getParameter("designation"));
		address.setD_no(request.getParameter("dno"));
		
		address.setStreet(request.getParameter("street"));
//		address.setCity(request.getParameter("city"));
//		address.setZipcode(request.getParameter("zipcode"));
//		address.setState(request.getParameter("state"));
		teacher.setAddress(address);
		
		teacherDao.addTeacher(teacher);
		response.sendRedirect("teacher-list");
	}

	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,NumberFormatException {
		Address address = new Address();
		Teacher teacher = new Teacher();
		teacher.setFname(request.getParameter("fname"));
		teacher.setLname(request.getParameter("lname"));
		teacher.setDob(LocalDate.parse(request.getParameter("dob")));
		teacher.setPhone(request.getParameter("phone"));
		teacher.setDesignation(request.getParameter("designation"));
		int id = Integer.parseInt(request.getParameter("id"));
		teacher.setId(id);
	//	address.setD_no(request.getParameter("dno"));
		address.setStreet(request.getParameter("street"));
//		address.setCity(request.getParameter("city"));
//		address.setZipcode(request.getParameter("zipcode"));
//		address.setState(request.getParameter("state"));
		teacher.setAddress(address);
		teacherDao.updateTeacher(teacher);
		response.sendRedirect("teacher-list");
	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teacherDao.deleteTeacher(teacher);
		response.sendRedirect("teacher-list");

	}


}
