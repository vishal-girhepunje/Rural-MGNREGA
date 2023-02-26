package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.security.auth.login.CredentialException;

import com.Exception.EmployeeException;
import com.Exception.GPMException;
import com.Exception.ProjectException;
import com.Model.EmpDto;
import com.Model.Employee;
import com.Utility.DBUtils;

public class GPMDaoImplement implements GPMDao {

	@Override
	public String GMPLogin(String gphone, String password) throws CredentialException, GPMException {
		// TODO Auto-generated method stub
String message="Invalid Input !";
		
		try(Connection con=DBUtils.ProvideConnection()){
			
			PreparedStatement ps=con.prepareStatement("select * from grampanchayatmember");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				String phone=rs.getString("gpmphone");
				String password1=rs.getString("gpmpassword");
				
				if(gphone.equals(phone) && password.equals(password1)) {
					message="Login Successfull ! Welcome to Gram Panchayt Member Dashboard";
					return message;
					
				}
			}
			
			message="Wrong Credentia !";
			throw new CredentialException(message);
			
			
		}
		catch(SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		
		
	}

	@Override
	public String CreateEmployee(EmpDto employee) throws EmployeeException {
		// TODO Auto-generated method stub
		String result ="Employee Not Created";
		
		try (Connection conn = DBUtils.ProvideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
			ps.setInt(1, employee.getEid());
			ps.setString(2, employee.getEname());
			ps.setString(3, employee.getEmobile());
			ps.setString(4, employee.getEaddress());
			ps.setInt(5, employee.getEtotaldaywork());
			ps.setString(6, employee.getEwages());
			ps.setInt(7, employee.getPid());
					
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				result = "Employee Created Successfully";
			}else {
				throw new EmployeeException(result);
			}
			
		} catch (SQLException s) {
			throw new EmployeeException(s.getMessage());
		}
		
		return result;
		
		
	}

	@Override
	public List<Employee> ListOfEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<>();
		
		try (Connection conn = DBUtils.ProvideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int eid = rs.getInt("eid");
				int egmpid = rs.getInt("egpmid");
				int epid = rs.getInt("epid");
				String ename = rs.getString("ename");
				String ephone=rs.getString("ephone");
				String eaddress = rs.getString("eaddress");
				Date edate = rs.getDate("edate");
				int ewage = rs.getInt("ewage");
				
				
				Employee e = new Employee(eid, ename, ephone, eaddress, eid, epid, ewage);
				empList.add(null);
			}
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		if(empList.size() ==0) {
			throw new EmployeeException("Exception : No Employeet Found.");
		}
		
		return empList;
	}

	@Override
	public String AssignProjectToEmployee(int pid, int eid) throws ProjectException, EmployeeException, GPMException {
		// TODO Auto-generated method stub
String result = "Employee not assinged to project";
		
		
		try (Connection conn = DBUtils.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where eid = ?");
			ps.setInt(1, eid);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("select * from project where pid = ? ");
				ps2.setInt(1, pid);
				
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()){
					
					PreparedStatement ps3 = conn.prepareStatement("update employee set epid = ? where eid =?");
					ps3.setInt(1, pid);
					ps3.setInt(2, eid);
					
					int x = ps3.executeUpdate();
					
					if(x>0) {
						result = "Project with PID ID : " + pid + " assigned to employee with EID ID : " + eid;
						return result;
					}
					
					
					
				}else {
					throw new ProjectException("Either Project don't exist or NOT assinged to Logined Gram Panchayat Member Account by BDO");
				}
				
				
			}else {
				throw new EmployeeException("Either employee don't exist or assigned by different Gram Panchayat Member ");
			}
			
			
			
			
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
	
		return result;
	}

	@Override
	public List<Employee> EmployeeDayWages() throws EmployeeException {
		// TODO Auto-generated method stub
		List<Employee> dayandWageList = new ArrayList<>();
		
		
		try (Connection conn = DBUtils.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(" select e.eid,e.ename,p.pid,p.pname,e.edate,datediff(curdate(),e.edate) days,e.ewage,datediff(curdate(),e.edate)*e.ewage total from employee e inner join project p on e.epid = p.pid group by e.eid");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				Date date = rs.getDate("edate");
				int days = rs.getInt("days");
				int wage = rs.getInt("ewage");
				int total = rs.getInt("total");
				
				Employee empWageTotal = new Employee(eid, ename, ename, pname, pid, days, wage);
				dayandWageList.add(empWageTotal);	
				
			}
			
			
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		
		if(dayandWageList.size() ==0) {
			throw new EmployeeException("Exception : No employee Found in DataBase");
		}
			
		return dayandWageList;
	}
	
}
