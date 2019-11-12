package com.training.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TourDetails {

	private long code;
	private String tourName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String places;
	private long numberOfDays;
	private long cost;
	public TourDetails() {
		super();
	}
	public TourDetails(long code, String tourName, LocalDate startDate, LocalDate endDate, String places,
			long numberOfDays, long cost) {
		super();
		this.code = code;
		this.tourName = tourName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.places = places;
		this.numberOfDays = numberOfDays;
		this.cost = cost;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getPlaces() {
		return places;
	}
	public void setPlaces(String places) {
		this.places = places;
	}
	public long getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(long numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "TourDetails [code=" + code + ", tourName=" + tourName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", places=" + places + ", numberOfDays=" + numberOfDays + ", cost=" + cost + "]";
	}

	
	
}
