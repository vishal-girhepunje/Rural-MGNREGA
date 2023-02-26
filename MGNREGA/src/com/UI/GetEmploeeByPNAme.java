package com.UI;

import java.util.List;
import java.util.Scanner;

import com.Dao.BDODao;
import com.Dao.BDODaoImplement;
import com.Model.EmpDto;

public class GetEmploeeByPNAme {
	public static void getEmplPname() {
			
			
			
			
			Scanner sc= new Scanner(System.in);
			
			System.out.println("Enter the Project Name");
			
			String cname= sc.next();
	
			
			BDODao dao = new BDODaoImplement();
			
			try {
			List<EmpDto> dtos= dao.getAllEmployeeByPname(cname);
			
			dtos.forEach(dto -> {
				System.out.println(dto);
				System.out.println("name "+ dto.getEname());
				System.out.println("Day_w "+ dto.getEtotaldaywork());
				System.out.println("Eaddress "+ dto.getEaddress());
				System.out.println("Emobile "+ dto.getEmobile());
				System.out.println("pname "+ dto.getPid());
				System.out.println("Ewages "+ dto.getEwages());
				System.out.println("****************************************")
				;
			});
			
			
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
	
		}
}
