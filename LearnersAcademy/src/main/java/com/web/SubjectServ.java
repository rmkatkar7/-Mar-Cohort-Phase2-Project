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
import com.bean.Subject;
import com.dao.SubjectDao;

/**
 * Servlet implementation class SubjectServ
 */
@WebServlet(urlPatterns = {"/subnew","/subedit","/subinsert","/subdelete","/subupdate","/sublist","/subject-list"})
public class SubjectServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SubjectDao subjectDao;
  
    public SubjectServ() {
        super();
        
    }
    @Override
    	public void init() throws ServletException {
    		subjectDao = new SubjectDao();
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
			case "/subnew":
				showNewForm(request, response);
				break;
			case "/subinsert":
				insertSubject(request, response);
				break;
			case "/subdelete":
				deleteSubject(request, response);
				break;
			case "/subedit":
				showEditForm(request, response);
				break;
			case "/subupdate":
				updateSubject(request, response);
				break;
			default:
				listSubject(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<Subject> listSubject = subjectDao.showAllSubjects();
		request.setAttribute("listSubject", listSubject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Subject existingSubject = subjectDao.selectSubject(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject.jsp");
		request.setAttribute("subject", existingSubject);
		dispatcher.forward(request, response);

	}

	private void insertSubject(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,NumberFormatException {
		Subject subject = new Subject();
		
		subject.setSub_name(request.getParameter("subname"));
				
		subjectDao.addSubject(subject);
		response.sendRedirect("subject-list");
	}

	private void updateSubject(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,NumberFormatException {
		
		Subject subject = new Subject();
		subject.setSub_name(request.getParameter("subname"));
		int id = Integer.parseInt(request.getParameter("subid"));
		subject.setSub_id(id);
		subjectDao.updateSubject(subject);
		response.sendRedirect("subject-list");
	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("subid"));
		Subject subject = new Subject();
		subject.setSub_id(id);
		subjectDao.deleteSubject(subject);
		response.sendRedirect("subject-list");

	}
}
