package com.UI;

import java.util.Scanner;

import com.Dao.GPMDao;
import com.Dao.GPMDaoImplement;
import com.Exception.EmployeeException;
import com.Model.EmpDto;



public class RegisterEmploye {
	public static void  LGpm() throws EmployeeException {
		

		     Scanner sc= new Scanner(System.in);


		       	System.out.println("Enter Employee id:");
				int id= sc.nextInt();

				System.out.println("Enter Employee  Name:");
				String name= sc.next();

				System.out.println("Enter Employee  phone:");
				String phone= sc.next();

				System.out.println("Enter Employee  address:");
				String address= sc.next();

				System.out.println("Enter Employee  totaldaywork:");
				int daywork= sc.nextInt();  

				System.out.println("Enter Employee wages:");
				String wages= sc.next();
				
				System.out.println("Enter Employee ProjectId:");
				int pid= sc.nextInt();

				EmpDto emp = new EmpDto(id, name, phone, address, daywork, wages,pid);

				GPMDao gdaao= new GPMDaoImplement();
				String result=gdaao.CreateEmployee(emp);		
				System.out.println(result);
				sc.close();
		
	}

}
