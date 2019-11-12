package com.training.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.daos.TourDetailsDao;
import com.training.entity.RegisterUser;
import com.training.entity.TourDetails;

/**
 * Servlet implementation class ViewTour
 */
public class ViewTrip extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private  TourDetailsDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTrip() {
        super();
        dao=new TourDetailsDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 List<TourDetails> result=new ArrayList<>();
		 String message="Exception";
		try {
			result = dao.findAll();
		} catch (SQLException e) {
			message="SQL Exception";
		}
		request.setAttribute("TourDetailsList", result);
//		System.out.println(result);
	

			 RequestDispatcher dispatcher=request.getRequestDispatcher("viewTour.jsp");
				request.setAttribute("tourList", result);
				dispatcher.forward(request, response);
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
			result = dao.add(tour);
		} catch (SQLException e) {
			message="SQL Exception";
		}
	
		 if (result==1) {
			 message="One Trip Details added";
		 }		
		 RequestDispatcher dispatcher=request.getRequestDispatcher("status.jsp");
		request.setAttribute("details", message);
		dispatcher.forward(request, response);
	}

}
