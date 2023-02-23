package com.UI;

import java.util.Scanner;

import com.Dao.BDODao;
import com.Dao.BDODaoImplement;
import com.Model.GPM;

public class RegisterGPM {
	public static void RGpm() {
		
        Scanner sc= new Scanner(System.in);
    	System.out.println("Enter Grampachyat member id:");
		int id= sc.nextInt();
		
		System.out.println("Enter Grampachyat member Name:");
		String name= sc.next();
		
		
		
		System.out.println("Enter Grampachyat member Email:");
		String email= sc.next();
		
		System.out.println("Enter Grampachyat member password:");
		String password= sc.next();
		
		System.out.println("Enter Grampachyat member phone:");
		String phone= sc.next();
		
		System.out.println("Enter Grampachyat member address:");
		String address= sc.next();

		
		
		BDODao dao=new BDODaoImplement();
		
		
		
		GPM mem= new GPM();
		
		mem.setGid(id);
		mem.setGname(name);
		mem.setGemail(email);
		mem.setGpassword(password);
		mem.setGmobile(phone);
		mem.setGaddress(address);
		
		

		String result= dao.registerGPM(mem);
		
		System.out.println(result);
	}
}
