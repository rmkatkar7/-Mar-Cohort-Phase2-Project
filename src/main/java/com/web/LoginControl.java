package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Admin;
import com.dao.LoginDao;

/**
 * Servlet implementation class LoginControl
 */

@WebServlet("/login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		doGet(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginDao login = new LoginDao();
		Admin admin = login.loginCheck(username, password);
		HttpSession session = request.getSession();
		if(admin!=null) {
			session.setAttribute("admin", admin);
			response.sendRedirect("dashboard.jsp");
		}
		else {
			System.out.println("Incorrect");
			session.setAttribute("invalid", "yes");
			response.sendRedirect("index.jsp");
		}
	}

}
