package com.Model;

public class Project {

	private int pid;
	private String pname;
	private String pcost;
	private String pissuedate;
	private int gpmid;

	public Project() {
		
	}

	public Project(int pid, String pname, String pcost, String pissuedate) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcost = pcost;
		this.pissuedate = pissuedate;
	}

	public Project(int pid, String pname, String pcost, String pissuedate, int gpmid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcost = pcost;
		this.pissuedate = pissuedate;
		this.gpmid = gpmid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcost() {
		return pcost;
	}

	public void setPcost(String pcost) {
		this.pcost = pcost;
	}

	public String getPissuedate() {
		return pissuedate;
	}

	public void setPissuedate(String pissuedate) {
		this.pissuedate = pissuedate;
	}

	public int getGpmid() {
		return gpmid;
	}

	public void setGpmid(int gpmid) {
		this.gpmid = gpmid;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", pname=" + pname + ", pcost=" + pcost + ", pissuedate=" + pissuedate
				+ ", gpmid=" + gpmid + "]";
	}
	
	
	
	

}
