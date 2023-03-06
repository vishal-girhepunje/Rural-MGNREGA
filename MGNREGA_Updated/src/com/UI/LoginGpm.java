package com.UI;
import java.util.Scanner;

import com.Dao.GPMDao;
import com.Dao.GpmDaoImpl;
import com.Exception.GPMException;
import com.Login.UserActivity;
import com.Model.GPM;

public class LoginGpm {
	
	
	public static void  LGpm() {
		
	Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Username:");
		String uname = sc.next();
		
		System.out.println("Enter Password:");
		String pass = sc.next();
		if(uname.equals("gpm") && pass.equals("gpm")) {
			System.out.println(" login successful");
			UserActivity.gpm();
		}else {
			System.out.println("Username or password are wrong try again");
			
		}	
	
	}
}
