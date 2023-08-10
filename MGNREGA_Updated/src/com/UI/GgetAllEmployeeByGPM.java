package com.UI;

import java.util.List;

import com.Dao.BDODao;
import com.Dao.BDODaoImplement;
import com.Dao.GPMDao;
import com.Dao.GpmDaoImpl;
import com.Exception.EmployeeException;
import com.Exception.GPMException;
import com.Model.Employee;
import com.Model.GPM;

public class GgetAllEmployeeByGPM {
	
	public static void GetAllEmployee()  {
		
		GPMDao dao=new GpmDaoImpl();
		
		try {
			List<Employee> empl=dao.getAllEmployeeByGPM();
			 
			empl.forEach(s->{
				
				System.out.println("************************************");
				
				System.out.println("Employee Name: "+s.getEname());
				System.out.println("Employee Mobile No: "+s.getEmobile());				
				System.out.println("Employee Address:  "+s.getEaddress());
				System.out.println("Employee TotalDay Work: "+s.getDayworked());
				System.out.println("Emplolyee Wages: "+s.getEwages());
				
				System.out.println("************************************");
			});
			
		} catch (EmployeeException e) {
		     System.out.println(e.getMessage());
		}
		
	}

}
