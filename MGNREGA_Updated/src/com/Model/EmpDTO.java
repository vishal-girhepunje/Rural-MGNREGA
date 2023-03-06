package com.Model;

public class EmpDTO {
	
	private String ename;
	private String emobile;
	private String eaddress;
	private int etotaldaywork;
	private int ewages;
	private String pname;

	

	public EmpDTO(String n, String m, String a, int d, String w, String p) {
		
	}


	public EmpDTO(String ename, String emobile, String eaddress, int etotaldaywork, String w, String pname, int ewages) {
		super();
		this.ename = ename;
		this.emobile = emobile;
		this.eaddress = eaddress;
		this.etotaldaywork = etotaldaywork;
		this.ewages = ewages;
		this.pname = pname;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getEmobile() {
		return emobile;
	}


	public void setEmobile(String emobile) {
		this.emobile = emobile;
	}


	public String getEaddress() {
		return eaddress;
	}


	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}


	public int getDayworked() {
		return etotaldaywork;
	}


	public void setDayworked(int etotoldayworke) {
		this.etotaldaywork = etotoldayworke;
	}


	public int getEwages() {
		return ewages;
	}


	public void setEwages(int ewages) {
		this.ewages = ewages;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	@Override
	public String toString() {
		return "EmployeeDTO [ename=" + ename + ", emobile=" + emobile + ", eaddress=" + eaddress + ", dayworked="
				+ etotaldaywork + ", ewages=" + ewages + ", pname=" + pname + "]";
	}
	

}
