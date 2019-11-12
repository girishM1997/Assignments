package com.training.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.daos.TourDetailsDao;
import com.training.entity.TourDetails;

/**
 * Servlet implementation class SearchTour
 */
public class SearchTour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  TourDetailsDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTour() {
        super();
        dao=new TourDetailsDao();
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
		 List<TourDetails> result=new ArrayList<>();
		 String tourName=request.getParameter("tourName");
		try {
			result.addAll(dao.findByTourName(tourName));
		} catch (SQLException e) {
			
		}
			 RequestDispatcher dispatcher=request.getRequestDispatcher("viewTour.jsp");
				request.setAttribute("tourList", result);
				dispatcher.forward(request, response);
	}
	
	
}
