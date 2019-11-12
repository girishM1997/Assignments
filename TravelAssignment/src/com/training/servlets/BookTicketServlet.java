package com.training.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.daos.BookTicketsDao;
import com.training.daos.TourDetailsDao;
import com.training.entity.BookTicket;
import com.training.entity.RegisterUser;
import com.training.entity.TourDetails;

/**
 * Servlet implementation class BookTicket
 */
public class BookTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private BookTicketsDao bookTicketDao;
       private  TourDetailsDao tourDao;
       private long ticketNumber;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTicketServlet() {
        super();
        bookTicketDao=new BookTicketsDao();
        tourDao=new TourDetailsDao();
        ticketNumber=0;
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
		
		 int result=0;
		 String message="Exception";
		 this.ticketNumber=ticketNumber+1;

		String strId=request.getParameter("code");
		long code=Long.parseLong(strId);
		
		String strNumberOfTickets=request.getParameter("numberOfTickets");
		long numberOfTickets=Long.parseLong(strNumberOfTickets);
		TourDetails tour=null;
		try {
			tour=tourDao.findById(code);
		} catch (SQLException e) {
			message="SQL Exception";
		}
		HttpSession session=request.getSession();
		RegisterUser user=(RegisterUser)session.getAttribute("user");
		long userId=user.getUserId();
		long totalCost=tour.getCost()*numberOfTickets;
		
		BookTicket bookTicket=new BookTicket(userId,this.ticketNumber,code,numberOfTickets,totalCost);
		 

		try {
			result = bookTicketDao.add(bookTicket);
		} catch (SQLException e) {
			message="SQL Exception";
		}
	
		 if (result==1) {
			 message="Tickets booked";
		 }		
		 RequestDispatcher dispatcher=request.getRequestDispatcher("status.jsp");
		request.setAttribute("details", message);
		request.setAttribute("totalCost","Total Cost:"+totalCost);
		dispatcher.forward(request, response);
	}

}
