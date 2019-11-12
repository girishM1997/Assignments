package com.training.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.daos.RegisterUsersDao;
import com.training.entity.RegisterUser;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterUsersDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        dao=new RegisterUsersDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterUser user=null;
	     String strId=request.getParameter("userId");
		long userId=Long.parseLong(strId);
		 String password=request.getParameter("password");
	
		 boolean status=false;
	    	try {
				user = dao.findById(userId);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	   	 if (user!=null && user.getPassword().equals(password)) {
				status=true;
			}
		 	if(status) {	
				 RequestDispatcher dispatcher=request.getRequestDispatcher("travelHome.jsp");
				 HttpSession session=request.getSession(true);
				session.setAttribute("user",user);
				dispatcher.forward(request, response);
		 	}

		 	else {
				 RequestDispatcher dispatcher=request.getRequestDispatcher("loginStatus.jsp");
					request.setAttribute("err", "Invalid user id and password");
					dispatcher.forward(request, response);
		 	}
	}

}
