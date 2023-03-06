package com.UI;

import java.util.Scanner;

import com.Dao.BDODao;
import com.Dao.BDODaoImplement;
import com.Dao.GPMDao;
import com.Dao.GpmDaoImpl;
import com.Model.Employee;
import com.Model.GPM;

public class RegisterEmployee {
	public static void REmployee() {
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
			
			
			BDODao dao=new BDODaoImplement();
			
			
			
			Employee emp= new Employee(id, name, phone, address, daywork, wages);
			
			GPMDao gdaao= new GpmDaoImpl();
			String result=gdaao.registerEmployee(emp);
		
		

			
			
			System.out.println(result);
	}

}
