package com.training.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.daos.TourDetailsDao;
import com.training.entity.TourDetails;

/**
 * Servlet implementation class UpdateTrip
 */
public class UpdateTrip extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  TourDetailsDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTrip() {
        super();
        dao=new TourDetailsDao();
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
		String strId=request.getParameter("code");
		long code=Long.parseLong(strId);

		 String tourName=request.getParameter("tourName");
		 String strSDate=request.getParameter("startDate");
		 LocalDate startDate=LocalDate.parse(strSDate);
		 String strEDate=request.getParameter("endDate");
		 LocalDate endDate=LocalDate.parse(strEDate);
		 String places=request.getParameter("places");
			String strDays=request.getParameter("numberOfDays");
			long numberOfDays=Long.parseLong(strDays);
			String strCost=request.getParameter("cost");
			long cost=Long.parseLong(strCost);
			TourDetails tour=new TourDetails(code,tourName,startDate,endDate,places,numberOfDays,cost);
		 
		 int result=0;
		 String message="Exception";
		try {
			result = dao.update(tour);
		} catch (SQLException e) {
			message="SQL Exception";
		}
	
		 if (result==1) {
			 message="One Trip Details updated";
		 }		
		 RequestDispatcher dispatcher=request.getRequestDispatcher("status.jsp");
		request.setAttribute("details", message);
		dispatcher.forward(request, response);
	}

}
