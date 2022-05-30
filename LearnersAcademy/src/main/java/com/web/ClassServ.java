package com.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.ClassTable;
import com.bean.Student;
import com.bean.SubjectTeacherClass;
import com.dao.AssignTeachersDao;
import com.dao.ClassDao;
import com.dao.StudentDao;


/**
 * Servlet implementation class ClassServ
 */
@WebServlet(urlPatterns = {"/cnew","/cedit","/cinsert","/cdelete","/cupdate","/clist","/class-list","/creport"})
public class ClassServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClassDao classDao;
    
    
    public void init() {
    	System.out.println("Inside ");
    	classDao = new ClassDao();
	}
    public ClassServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.println("Servlet path "+action);

		try {
			switch (action) {
			case "/cnew":
				showNewForm(request, response);
				break;
			case "/cinsert":
				insertClass(request, response);
				break;
			case "/cdelete":
				deleteClass(request, response);
				break;
			case "/cedit":
				showEditForm(request, response);
				break;
			case "/cupdate":
				updateClass(request, response);
				break;
			case "/creport":
				listClassReport(request, response);
				break;
			default:
				listClass(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	
	private void listClass(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<ClassTable> listClass = classDao.showAllClasses();
		request.setAttribute("listClass", listClass);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("class.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("cid"));
		ClassTable existingClass = classDao.selectClass(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class.jsp");
		request.setAttribute("clas", existingClass);
		dispatcher.forward(request, response);

	}

	private void insertClass(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,NumberFormatException {
		
		ClassTable classTable  = new ClassTable();
		classTable.setClass_name(request.getParameter("fname"));
		classDao.AddClass(classTable);
		response.sendRedirect("class-list");
	}

	private void updateClass(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,NumberFormatException {
		ClassTable classTable  = new ClassTable();
		classTable.setClass_name(request.getParameter("fname"));
		
		int cid = Integer.parseInt(request.getParameter("cid"));
		classTable.setCid(cid);
		classDao.updateClass(classTable);
		response.sendRedirect("class-list");
	}

	private void deleteClass(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("cid"));
		ClassTable classTable  = new ClassTable();
		classTable.setCid(id);
		classDao.deleteClass(classTable);
		response.sendRedirect("class-list");

	}
	private void listClassReport(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		StudentDao studentDao = new StudentDao();
		AssignTeachersDao classReport = new AssignTeachersDao();
		int cid = Integer.parseInt(request.getParameter("cid"));
		List<Student> students = studentDao.GetStudentByClass(cid);
		request.setAttribute("listStudent", students);
		List<SubjectTeacherClass> subTeacherList = classReport.classReportByID(cid);
		request.setAttribute("listClassReport", subTeacherList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class-report.jsp");
		dispatcher.forward(request, response);
	}
	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
