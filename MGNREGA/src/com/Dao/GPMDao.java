package com.Dao;

import java.util.List;

import javax.security.auth.login.CredentialException;

import com.Exception.EmployeeException;
import com.Exception.GPMException;
import com.Exception.ProjectException;
import com.Model.EmpDto;
import com.Model.Employee;
import com.Model.GPM;

public interface GPMDao {
	
	public String GMPLogin(String gphone,String password) throws CredentialException,GPMException;
	
	public String CreateEmployee(EmpDto employee) throws EmployeeException;
	
	public List<Employee> ListOfEmployee() throws EmployeeException;
	
	public String AssignProjectToEmployee(int pid,int eid) throws ProjectException,EmployeeException,GPMException;
	
	public List<Employee> EmployeeDayWages() throws EmployeeException;
}
