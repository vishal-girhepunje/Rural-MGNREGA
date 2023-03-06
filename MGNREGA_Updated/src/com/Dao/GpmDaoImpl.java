package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Exception.GPMException;
import com.Model.Employee;
import com.Model.GPM;
import com.Utility.DBUtil;

public class GpmDaoImpl implements GPMDao{

	@Override
	public GPM loginGPM(String username, String password) throws GPMException {
	  
		GPM gpm = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
		
			PreparedStatement ps= conn.prepareStatement("select * from gpm where gemail = ? AND gpassword = ?");			
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
		
				if(rs.next()) {
				
				int id= rs.getInt("gid");
				String n= rs.getString("gname");
				String e= rs.getString("gemail");
				String p= rs.getString("gpassword");
				String m = rs.getString("gmobile");
				String a = rs.getString("gaddress");
				int bdoid = rs.getInt("bdoid");
				
				gpm =new GPM (id, n, e, p, m, a, bdoid);	
			
			}else
				throw new GPMException("Invalid Username or password.. ");
			
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		return gpm;
	}

	@Override
	public String registerEmployee(Employee employee) {
		
         String message = "Not Inserted..";
	
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into employee values(?,?,?,?,?,?)");
			
			
			ps.setInt(1, employee.getEid());
			ps.setString(2, employee.getEname());
			ps.setString(3, employee.getEmobile());
			ps.setString(4, employee.getEaddress());
			ps.setInt(5, employee.getDayworked());
			ps.setString(6, employee.getEwages());
			
			int x= ps.executeUpdate();
			
			if(x > 0)
				message = "Employee Registered Sucessfully !";
		
		} catch (SQLException e) {
			message = e.getMessage();
		}
	
		return message;
	}

}
