package com.training.servlets;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.daos.RegisterUsersDao;

import com.training.entity.RegisterUser;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private RegisterUsersDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        dao=new RegisterUsersDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	     String strId=request.getParameter("userId");
			long userId=Long.parseLong(strId);

			 String firstName=request.getParameter("firstName");
			 String lastName=request.getParameter("lastName");
			 String password=request.getParameter("password");
			 String typeOfUser=request.getParameter("typeOfUser");
			// String strDob=request.getParameter("dateOfBirth");
			 //LocalDate dob=LocalDate.parse(strDob);
			
			RegisterUser user=new RegisterUser(firstName, lastName, userId, password, typeOfUser);
			 
			 int result=0;
			 String message="Exception";
			try {
				result = dao.add(user);
			} catch (SQLException e) {
				message="SQL Exception";
			}
		
			 if (result==1) {
				 message="One user added";
			 }		
			 RequestDispatcher dispatcher=request.getRequestDispatcher("login.html");
				request.setAttribute("user", message);
				dispatcher.forward(request, response);
		
	}

}
