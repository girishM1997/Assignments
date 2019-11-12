package com.training.entity;

public class BookTicket {

	private long userId;
	private long ticketNumber;
	private long tourCode;
	private long numberOfTickets;
	private long totalCost;
	public BookTicket() {
		super();
	}
	public BookTicket(long userId, long ticketNumber, long tourCode, long numberOfTickets, long totalCost) {
		super();
		this.userId = userId;
		this.ticketNumber = ticketNumber;
		this.tourCode = tourCode;
		this.numberOfTickets = numberOfTickets;
		this.totalCost = totalCost;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public long getTourCode() {
		return tourCode;
	}
	public void setTourCode(long tourCode) {
		this.tourCode = tourCode;
	}
	public long getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(long numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	public long getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}
	
	@Override
	public String toString() {
		return "BookTicket [userId=" + userId + ", ticketNumber=" + ticketNumber + ", tourCode=" + tourCode
				+ ", numberOfTickets=" + numberOfTickets + ", totalCost=" + totalCost + "]";
	}

}
