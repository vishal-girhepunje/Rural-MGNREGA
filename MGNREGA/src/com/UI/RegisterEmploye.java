package com.UI;

import java.util.Scanner;

import com.LogIn.UserActivity;

public class RegisterEmploye {
	public static void  LGpm() {
		
		Scanner sc= new Scanner(System.in);
			
			System.out.println("Enter Username:");
			String uname = sc.next();
			
			System.out.println("Enter Password:");
			String pass = sc.next();
			if(uname.equals("ahtisham@567") && pass.equals("ahtisham567")) {
				System.out.println(" login successful");
				UserActivity.gpm();
			}else {
				System.out.println("Username or password are wrong try again");
				
			}	
		
		}

	public static void LGpm1() {
		// TODO Auto-generated method stub
		
	}
}
