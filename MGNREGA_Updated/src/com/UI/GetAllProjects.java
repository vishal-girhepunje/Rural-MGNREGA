package com.UI;

import java.util.List;

import com.Dao.BDODao;
import com.Dao.BDODaoImplement;
import com.Exception.ProjectException;
import com.Model.Project;

public class GetAllProjects {
	
	public static void GAllProjects() {
		
		BDODao dao = new BDODaoImplement();
		
		try {
			List<Project> projects=dao.getAllProjectDetails();
			projects.forEach(s->{
				System.out.println("==========================================");
				
				System.out.println("Project Name :"+s.getPname());
				System.out.println("Project cost: "+s.getPcost());
				System.out.println("Project issuedate: "+s.getPissuedate());
				
				System.out.println("==========================================");
			});
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
	
		
	}

}
