package com.Model;

public class EmpDto {
	private String ename;
	private String pname;
	private int etotaldaywork;
	private int ewages;
	private String emobile;
	private String eaddress;
	public EmpDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpDto(String ename, String pname, int etotaldaywork, int ewages, String emobile, String eaddress) {
		super();
		this.ename = ename;
		this.pname = pname;
		this.etotaldaywork = etotaldaywork;
		this.ewages = ewages;
		this.emobile = emobile;
		this.eaddress = eaddress;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getEtotaldaywork() {
		return etotaldaywork;
	}
	public void setEtotaldaywork(int etotaldaywork) {
		this.etotaldaywork = etotaldaywork;
	}
	public int getEwages() {
		return ewages;
	}
	public void setEwages(int ewages) {
		this.ewages = ewages;
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
	@Override
	public String toString() {
		return "EmpDto [ename=" + ename + ", pname=" + pname + ", etotaldaywork=" + etotaldaywork + ", ewages=" + ewages
				+ ", emobile=" + emobile + ", eaddress=" + eaddress + "]";
	}
	
	
}
