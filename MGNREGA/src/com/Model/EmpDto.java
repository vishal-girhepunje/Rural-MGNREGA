package com.Model;

public class EmpDto {
	private int eid;
	private String ename;
	private String emobile;
	private String eaddress;
	private int etotaldaywork;
	private String ewages;
	private int pid;
	
	public EmpDto() {
		
	}

	public EmpDto(int eid, String ename, String emobile, String eaddress, int etotaldaywork, String ewages, int pid) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.emobile = emobile;
		this.eaddress = eaddress;
		this.etotaldaywork = etotaldaywork;
		this.ewages = ewages;
		this.pid = pid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
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

	public int getEtotaldaywork() {
		return etotaldaywork;
	}

	public void setEtotaldaywork(int etotaldaywork) {
		this.etotaldaywork = etotaldaywork;
	}

	public String getEwages() {
		return ewages;
	}

	public void setEwages(String ewages) {
		this.ewages = ewages;
	}

	@Override
	public String toString() {
		return "eid=" + eid + ", ename=" + ename + ", emobile=" + emobile + ", eaddress=" + eaddress
				+ ", etotaldaywork=" + etotaldaywork + ", ewages=" + ewages + ", pid=" + pid + "\n";
	}

	
	
	
}
