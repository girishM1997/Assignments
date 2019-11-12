package com.training.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.training.entity.BookTicket;
import com.training.ifaces.Dao;
import com.training.utils.DbConnection;

public class BookTicketsDao implements Dao<BookTicket> {

	private Connection con;
	
	public BookTicketsDao() {
		super();
		this.con = DbConnection.getOracleConnection();
	}

	@Override
	public int add(BookTicket t) throws SQLException {
		String sql = "insert into GmBookTickets values(?,?,?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setLong(1, t.getTicketNumber());
		pstmt.setLong(2,t.getUserId());
		pstmt.setLong(3, t.getTourCode());
		pstmt.setLong(4, t.getNumberOfTickets());	      
		pstmt.setLong(5, t.getTotalCost());
		
		return pstmt.executeUpdate();
	}

	@Override
	public List<BookTicket> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookTicket findById(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(BookTicket t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(long id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
