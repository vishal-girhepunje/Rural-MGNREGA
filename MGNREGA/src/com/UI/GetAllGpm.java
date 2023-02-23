package com.UI;

import java.util.List;

import com.Dao.BDODao;
import com.Dao.BDODaoImplement;
import com.Exception.GPMException;
import com.Model.GPM;

public class GetAllGpm {
public static void GAllGpm()  {
		
		BDODao dao=new BDODaoImplement();
		
		try {
			List<GPM> gpm=dao.getAllGPM();
			 
			gpm.forEach(s->{
				
				System.out.println("************************************");
				
				System.out.println("Grampchyat member name: "+s.getGname());
				System.out.println("Grampchyat member email: "+s.getGemail());
				System.out.println("Grampchyat member Password: "+s.getGpassword());
				System.out.println("Grampchyat member Mobile:   "+s.getGmobile());
				
				System.out.println("Grampchyat member Address:  "+s.getGaddress());
				
				System.out.println("************************************");
			});
			
		} catch (GPMException e) {
		     System.out.println(e.getMessage());
		}
		
	}
}
