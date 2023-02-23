package com.UI;

import java.util.Scanner;

import com.Dao.BDODao;
import com.Dao.BDODaoImplement;
import com.Exception.EmployeeException;
import com.Exception.ProjectException;

public class AssignProjectToEmployee {
	 public static void AProjecttoEmp() {
		  Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter the Project id");
			int pd=sc.nextInt();
			
			System.out.println("Enter the Employee id");
			int ed=sc.nextInt();
			
		
			
			try {

				BDODao bd= new BDODaoImplement();
		
			try {
				String rs = bd.AssignProjectToEmployeee(pd, ed);
				System.out.println(rs);
			} catch (ProjectException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
