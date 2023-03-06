package com.Dao;

import com.Exception.GPMException;
import com.Model.Employee;
import com.Model.GPM;

public interface GPMDao {
	
    public GPM loginGPM(String username, String password)throws GPMException;
    
	public String registerEmployee(Employee employee);

//	public List<Employee> getAllGPM()throws EmployeeException;
//	
//	public String registerEmployeeToProject(int pid, int eid)throws ProjectException, EmployeeException ;
//
//
//	public EmployeeDTO getEmployeeByMobile(String emobile)throws ProjectException;


}
