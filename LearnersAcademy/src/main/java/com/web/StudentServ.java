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
import com.bean.ClassTable;
import com.bean.Student;
import com.dao.ClassDao;
import com.dao.StudentDao;

/**
 * Servlet implementation class StudentServ
 */
@WebServlet(urlPatterns = {"/snew","/sedit","/sinsert","/sdelete","/supdate","/slist","/student-list"})
public class StudentServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDao studentDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServ() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	System.out.println("Inside student");
    	studentDao = new StudentDao();
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
			case "/snew":
				showNewForm(request, response);
				break;
			case "/sinsert":
				insertStudent(request, response);
				break;
			case "/sdelete":
				deleteStudent(request, response);
				break;
			case "/sedit":
				showEditForm(request, response);
				break;
			case "/supdate":
				updateStudent(request, response);
				break;
			default:
				listStudent(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<Student> listStudent = studentDao.showAllStudents();
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassDao classaDao = new ClassDao();
		List<ClassTable> listclass = classaDao.showAllClasses();
		request.setAttribute("listClass", listclass);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Student existingStudent = studentDao.selectStudent(id);
		ClassDao classaDao = new ClassDao();
		List<ClassTable> listclass = classaDao.showAllClasses();
		request.setAttribute("listClass", listclass);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student.jsp");
		request.setAttribute("student", existingStudent);
		dispatcher.forward(request, response);

	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,NumberFormatException {
		Address address = new Address();
		Student student = new Student();
		student.setFname(request.getParameter("fname"));
		student.setLname(request.getParameter("lname"));
		student.setDob(LocalDate.parse(request.getParameter("dob")));
		student.setPhone(request.getParameter("phone"));
		int cid = Integer.parseInt(request.getParameter("class"));
		ClassTable newClass = new ClassTable();
		newClass.setCid(cid);
		System.out.println("inside insert");
//		address.setD_no(request.getParameter("dno"));
//		
		address.setStreet(request.getParameter("street"));
//		address.setCity(request.getParameter("city"));
//		address.setZipcode(request.getParameter("zipcode"));
//		address.setState(request.getParameter("state"));
		student.setAddress(address);
		studentDao.addStudent(student,newClass);
		response.sendRedirect("student-list");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,NumberFormatException {
		Address address = new Address();
		Student student = new Student();
		student.setFname(request.getParameter("fname"));
		student.setLname(request.getParameter("lname"));
		student.setDob(LocalDate.parse(request.getParameter("dob")));
		student.setPhone(request.getParameter("phone"));
		int id = Integer.parseInt(request.getParameter("id"));
		student.setId(id);
	//	address.setD_no(request.getParameter("dno"));
		address.setStreet(request.getParameter("street"));
		int cid = Integer.parseInt(request.getParameter("class"));
		ClassTable newClass = new ClassTable();
		newClass.setCid(cid);
//		address.setCity(request.getParameter("city"));
//		address.setZipcode(request.getParameter("zipcode"));
//		address.setState(request.getParameter("state"));
		student.setAddress(address);
		studentDao.updateStudent(student,newClass);
		response.sendRedirect("student-list");
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = new Student();
		student.setId(id);
		studentDao.deleteStudent(student);
		response.sendRedirect("student-list");

	}

}
