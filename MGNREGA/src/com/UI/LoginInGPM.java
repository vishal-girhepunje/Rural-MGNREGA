package com.UI;

import java.util.Scanner;

import com.LogIn.UserActivity;

public class LoginInGPM {
	public static void  LGpm() throws Exception {
		
		Scanner sc= new Scanner(System.in);
			
			System.out.println("Enter Username:");
			String uname = sc.next();
			
			System.out.println("Enter Password:");
			String pass = sc.next();
			if(uname.equals("vishal@gmail.com") && pass.equals("vishal@123")) {
				System.out.println(" login successful");
				UserActivity.gpm();
			}else {
				System.out.println("Username or password are wrong try again");
				
			}	
		
		}
}
