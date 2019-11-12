package com.training.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.training.entity.RegisterUser;
import com.training.entity.TourDetails;
import com.training.ifaces.Dao;
import com.training.utils.DbConnection;

public class TourDetailsDao implements Dao<TourDetails> {

	private Connection con;
	
	public TourDetailsDao() {
		super();
		this.con = DbConnection.getOracleConnection();
	}

	@Override
	public int add(TourDetails t) throws SQLException {
		String sql = "insert into GmtourDetails values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setLong(1, t.getCode());
		pstmt.setString(2, t.getTourName());
		Date startDate=Date.valueOf(t.getStartDate());
		pstmt.setDate(3,startDate);
		Date endDate=Date.valueOf(t.getEndDate());
		pstmt.setDate(4,endDate);
		pstmt.setString(5,t.getPlaces());
		pstmt.setLong(6, t.getNumberOfDays());	      
		pstmt.setLong(7, t.getCost());
		
		return pstmt.executeUpdate();
	}

	@Override
	public List<TourDetails> findAll() throws SQLException {
		String sql = "select * from GmtourDetails";
		PreparedStatement pstmt=  con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();

		List<TourDetails> tourDetailsList = new ArrayList<>();
		
		while(rs.next()) {
			 
			TourDetails tour = mapToRow(rs);
			 
			tourDetailsList.add(tour);
		 }
		
		return tourDetailsList;
	}
	public TourDetails mapToRow(ResultSet rs)  throws SQLException{
		
		long code=rs.getLong("code");
		String tourName = rs.getString("tourName");
		Date sdate=rs.getDate("startDate");
		LocalDate startDate=sdate.toLocalDate();
		Date edate=rs.getDate("endDate");
		LocalDate endDate=edate.toLocalDate();
		String places = rs.getString("places");
		long numberOfDays=rs.getLong("numberOfDays");
		long cost=rs.getLong("cost");
		return new TourDetails(code,tourName,startDate,endDate,places,numberOfDays,cost);
	}
	@Override
	public TourDetails findById(long id) throws SQLException {
		String sql = "select * from  GmtourDetails where code=?";
		PreparedStatement pstmt=  con.prepareStatement(sql);
		TourDetails tour =null;
		pstmt.setLong(1,id);
		
		ResultSet rs = pstmt.executeQuery();
		
		  if(rs.next()) {
			  tour = mapToRow(rs);
			 
		  }
		  
		  return tour;
	}
	
	public List<TourDetails> findByTourName(String tourName) throws SQLException {
		String sql = "select * from GmtourDetails where tourName=?";
		PreparedStatement pstmt=  con.prepareStatement(sql);
		pstmt.setString(1, tourName);
		ResultSet rs = pstmt.executeQuery();

		List<TourDetails> tourDetailsList = new ArrayList<>();
		
		while(rs.next()) {
			 
			TourDetails tour = mapToRow(rs);
			 
			tourDetailsList.add(tour);
		 }
		
		return tourDetailsList;
	}
	@Override
	public int update(TourDetails t) throws SQLException {
		String sql="update GmtourDetails set tourName=?,startDate=?,endDate=?,places=?,numberOfDays=?,cost=? where code=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		
		//Here t denotes the ? in sql argument and NOT COLUMN NUMBER
		pstmt.setLong(7, t.getCode());
		pstmt.setString(1, t.getTourName());
		Date startDate=Date.valueOf(t.getStartDate());
		pstmt.setDate(2,startDate);
		Date endDate=Date.valueOf(t.getEndDate());
		pstmt.setDate(3,endDate);
		pstmt.setString(4,t.getPlaces()); 	
		pstmt.setLong(5, t.getNumberOfDays());	      
		pstmt.setLong(6, t.getCost());
		int rowUpdated=pstmt.executeUpdate();
		
		return rowUpdated;
		
	}

	@Override
	public int remove(long id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
