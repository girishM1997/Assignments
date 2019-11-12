package com.training.daos;

import com.training.ifaces.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.training.entity.RegisterUser;
import com.training.entity.RegisterUser;
import com.training.utils.DbConnection;

public class RegisterUsersDao implements Dao<RegisterUser> {

private Connection con;
	
	
	
	public RegisterUsersDao() {
		super();
	
		this.con = DbConnection.getOracleConnection();
	}

	@Override
	public int add(RegisterUser t) throws SQLException {
		
		String sql = "insert into GmUser values(?,?,?,?,?)";
		PreparedStatement pstmt= createStatement(sql);
		
		pstmt.setString(1, t.getFirstName());
		pstmt.setString(2, t.getLastName());
		pstmt.setLong(3, t.getUserId());
		pstmt.setString(4, t.getPassword());
		pstmt.setString(5, t.getTypeOfUser());
		
		return pstmt.executeUpdate();
	}

	@Override
	public List<RegisterUser> findAll() throws SQLException {

		String sql = "select * from GmUser";
		PreparedStatement pstmt= createStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();

		List<RegisterUser> userList = new ArrayList<>();
		
		while(rs.next()) {
			 
			RegisterUser cust = mapToRow(rs);
			 
			userList.add(cust);
		 }
		
		return userList;
	}

	@Override
	public RegisterUser findById(long id) throws SQLException {
		String sql = "select * from  GmUser where userId =?";
		PreparedStatement pstmt= createStatement(sql);
		RegisterUser user =null;
		pstmt.setLong(1,id);
		
		ResultSet rs = pstmt.executeQuery();
		
		  if(rs.next()) {
			  user = mapToRow(rs);
			 
		  }
		  
		  return user;
	}

//	@Override
//	public int update(RegisterUser t) throws SQLException {
//		return 0;
//	}

//    @Override
//    public int remove(long id) throws SQLException {
//                    String sql = "delete  from GmUser where userId =?";
//                    PreparedStatement pstmt= createStatement(sql);
//                    
//                    pstmt.setLong(1,id);
//                    
//                    return  pstmt.executeUpdate();                
//     }

	

	public PreparedStatement createStatement(String sql) throws SQLException {
		
		
		return  con.prepareCall(sql);
		 
	}
	
	public RegisterUser mapToRow(ResultSet rs)  throws SQLException{
		
		
		String firstName = rs.getString("firstName");
		String lastName = rs.getString("lastName");
		long userId=rs.getLong("userId");
		String password = rs.getString("password");
		String typeOfUser = rs.getString("typeOfUser");

		return new RegisterUser(firstName,lastName,userId,password,typeOfUser);
	}

	@Override
	public int update(RegisterUser t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(long id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

//	public List<Users> findByGroup(String bloodGroup) throws SQLException {
//		String sql = "select * from Users where bloodGroup =?";
//		List<Users> userList = new ArrayList<>();
//
//		PreparedStatement pstmt;
//		try {
//			pstmt = createStatement(sql);
//			pstmt.setString(1,bloodGroup);
//			ResultSet rs = pstmt.executeQuery();
//
//			
//			 while(rs.next()) {
//				 Users  user = mapToRow(rs);
//				 userList.add(user);
//			  }
//			  
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		  return userList;
//	}
	
	

}
