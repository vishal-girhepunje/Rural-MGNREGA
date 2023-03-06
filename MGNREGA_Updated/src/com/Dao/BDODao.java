package com.Dao;

import java.util.List;

import com.Exception.BDOException;
import com.Exception.EmployeeException;
import com.Exception.GPMException;
import com.Exception.ProjectException;
import com.Model.BDO;
import com.Model.EmpDTO;
import com.Model.GPM;
import com.Model.Project;

public interface BDODao {
	
     public BDO loginBDO(String username, String password)throws BDOException;
	
	public String createProject(int pid, String pname, String pcost, String pissuedate);
	
	public List<Project> getAllProjectDetails()throws ProjectException;

	public String registerGPM(GPM gpm);

	public List<GPM> getAllGPM()throws GPMException;
	
	
	public String AssignProjectToGPM(int pid, int gid)throws GPMException,ProjectException ;
	
	public String AssignProjectToEmployeee(int pid, int eid)throws EmployeeException,ProjectException ;
	
	public List<EmpDTO> getAllEmployeeByPname(String pname)throws ProjectException;


}