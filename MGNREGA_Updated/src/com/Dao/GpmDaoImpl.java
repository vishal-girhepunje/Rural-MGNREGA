package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Exception.EmployeeException;
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

	@Override
	public List<Employee> getAllEmployeeByGPM() throws EmployeeException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				List<Employee> employees=new ArrayList<>();
				

				  try( Connection conn=DBUtil.provideConnection()) {
					  PreparedStatement ps=conn.prepareStatement("select * from Employee");
					  
					  ResultSet rs=ps.executeQuery();
					  while(rs.next()) {
						  int ei=rs.getInt("eid");
						  String en=rs.getString("ename");
						  String em=rs.getString("emobile");
						  String ea=rs.getString("eaddress");
						  int etd=rs.getInt("etotaldaywork");
						  int ew=rs.getInt("ewages");
						
						  
						  Employee employee=new Employee(ei, en, em, ea, etd, ea);
						  
						  employees.add(employee);
					  }
					  
					
				} catch (SQLException e) {
					throw new EmployeeException(e.getMessage());
				}
				  
			    if(employees.size()==0) 
			    	throw new EmployeeException("No Employee found....");
			 
			    
				return employees;
	}

}
