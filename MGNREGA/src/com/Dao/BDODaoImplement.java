package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Exception.BDOException;
import com.Exception.EmployeeException;
import com.Exception.GPMException;
import com.Exception.ProjectException;
import com.Model.BDO;
import com.Model.EmpDto;
import com.Model.GPM;
import com.Model.Project;
import com.Utility.DBUtils;

public class BDODaoImplement implements BDODao {

	@Override
	public BDO loginBDO(String username, String password) throws BDOException {
		// TODO Auto-generated method stub
		BDO BDO = null;
		
		try(Connection conn = DBUtils.ProvideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from Bdo where bemail = ? AND bpassword = ?");			
			
			ps.setString(1,  username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			
				if(rs.next()) {
				
				int r= rs.getInt("bid");
				String e= rs.getString("bemail");
				String p= rs.getString("bpassword");
				
				
			BDO=new BDO(r, e, p);	
				
				
			}else
				throw new BDOException("Invalid Username or password.. ");
		
		} catch (SQLException e) {
			throw new BDOException(e.getMessage());
		} 

		return BDO;
		
	}

	@Override
	public String createProject(int pid, String pname, String pcost, String pissuedate) {
		// TODO Auto-generated method stub
		String message = "Not Inserted..";
	
		
	
		
		try(Connection conn= DBUtils.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into project(pid,pname,pcost,pissuedate) values(?,?,?,?)");
			
			
			
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setString(3, pcost);
			ps.setString(4, pissuedate);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Project Registered Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
	
		return message;
	}

	@Override
	public List<Project> getAllProjectDetails() throws ProjectException {
		// TODO Auto-generated method stub
		List<Project> projects= new ArrayList<>();
		  
		  
		 
		  try( Connection conn=DBUtils.ProvideConnection()) {
			  PreparedStatement ps=conn.prepareStatement("select * from Project");
			  
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()) {
				  int r=rs.getInt("pid");
				  String n=rs.getString("pname");
				  String c=rs.getString("pcost");
				  String d=rs.getString("pissuedate");
				
				  
				  Project project=new Project(r, n);
				  
				  projects.add(project);
			  }
			  
			
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		  
	    if(projects.size()==0) 
	    	throw new ProjectException("No Projects found....");
	 
	    return projects;
	}

	@Override
	public String registerGPM(GPM gpm) {
		// TODO Auto-generated method stub
		String message="NOt Inserted....";
		
		try (Connection conn= DBUtils.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into Gpm values(?,?,?,?,?,?)");
			
			
			
			ps.setInt(1, gpm.getGid());
			ps.setString(2, gpm.getGname());
			ps.setString(3, gpm.getGemail());
			ps.setString(4, gpm.getGpassword());
			ps.setString(5, gpm.getGmobile());
			ps.setString(6, gpm.getGaddress());
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Grampachayat member Registered Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public List<GPM> getAllGPM() throws GPMException {
		// TODO Auto-generated method stub
		 List<GPM> gpms= new ArrayList<>();
		  
		  try( Connection conn=DBUtils.ProvideConnection()) {
			  PreparedStatement ps=conn.prepareStatement("select * from Gpm");
			  
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()) {
				  
				  
				    int id= rs.getInt("gid");
					String n= rs.getString("gname");
					String e= rs.getString("gemail");
					String p= rs.getString("gpassword");
					String m= rs.getString("gmobile");
					String a = rs.getString("gaddress");
					
				  GPM gpm=new GPM(id, n, e, p, m, id, a);
				  gpms.add(gpm);
			  }
			  
			
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		  
	    if(gpms.size()==0) 
	    	throw new GPMException("No Grampanchaytmember found....");
	 
	    return gpms;  
	}

	@Override
	public String AssignProjectToGPM(int pid, int gid) throws GPMException, ProjectException {
		// TODO Auto-generated method stub
		String message="Not inserted";
		
		try(Connection conn= DBUtils.ProvideConnection()) {
		PreparedStatement ps=	conn.prepareStatement("select * from project where pid=?");
		
		ps.setInt(1,pid);
		
		ResultSet rs= ps.executeQuery();
		
		if(rs.next()) {
			PreparedStatement ps2=	conn.prepareStatement("select * from gpm where gid=?");
			ps2.setInt(1,gid);
			
			ResultSet rs2= ps2.executeQuery();
			
			if(rs2.next()) {
				PreparedStatement ps3=	conn.prepareStatement("insert into gpm_project values(?,?)");
				
				ps3.setInt(1,pid);
				ps3.setInt(2,gid);
				
				int x= ps3.executeUpdate();
				
				if(x>0) {
				message="GPM Project Added succesfully";
				}else 
				throw new ProjectException("Invalid Project id");
				
			}else
			throw new GPMException("Invalid GPM id");
		}else {
			throw new ProjectException("Invalid Project id");
		}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return message;
		
	}

	@Override
	public String AssignProjectToEmployeee(int pid, int eid) throws EmployeeException, ProjectException {
		// TODO Auto-generated method stub
		String message="Not inserted";
		
		try(Connection conn= DBUtils.ProvideConnection()) {
		PreparedStatement ps=	conn.prepareStatement("select * from project where pid=?");
		
		ps.setInt(1,pid);
		
		ResultSet rs= ps.executeQuery();
		
		if(rs.next()) {
			PreparedStatement ps2=	conn.prepareStatement("select * from employee where eid=?");
			ps2.setInt(1,eid);
			
			ResultSet rs2= ps2.executeQuery();
			
			if(rs2.next()) {
				PreparedStatement ps3=	conn.prepareStatement("insert into  project_employee values(?,?)");
				
				ps3.setInt(1,pid);
				ps3.setInt(2,eid);
				
				int x= ps3.executeUpdate();
				
				if(x>0) {
				message="Employee Project Added succesfully";
				}else 
				throw new ProjectException("Invalid Project id");
				
			}else
			throw new GPMException("Invalid Employee id");
		}else {
			throw new ProjectException("Invalid Project id");
		}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return message;
		
	}

	@Override
	public List<EmpDto> getAllEmployeeByPname(String pname) throws ProjectException {
		// TODO Auto-generated method stub

		List<EmpDto> edtos = new ArrayList<>();
	
		try (Connection conn = DBUtils.ProvideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select e.ename, e.emobile,e.eaddress, e.etotaldaywork, e.ewages, p.pname from "
					+ " employee e INNER JOIN project p INNER JOIN project_employee pe ON e.eid = "
					+ "pe.eid AND p.pid = pe.pid AND p.pname= ?");
			
			ps.setString(1, pname);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				String n= rs.getString("e.ename");
				String m= rs.getString("e.emobile");
				
				String a= rs.getString("e.eaddress");
				int d= rs.getInt("e.etotaldaywork");
				String w = rs.getString("e.ewages");
				String p = rs.getString("p.pname");
				
				
				EmpDto  ed=new EmpDto(pname, pname, d, d, m, a);
				edtos.add(ed);
				
				
				
			}		
			
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
			
		if(edtos.isEmpty())
			throw new ProjectException("No Employee found in the Project");
			
		return edtos;
	}

}
