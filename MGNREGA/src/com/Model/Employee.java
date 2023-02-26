package com.Model;

public class Employee {
	private int eid;
    private String ename;
    private String eage;
    private String gender;
    private int projectid;
    private int no_of_Day;
    private int wages;
    
	public Employee() {
		
	}
	
	public Employee(int eid, String ename, String eage, String gender, int projectid, int no_of_Day, int wages) {
		this.eid = eid;
		this.ename = ename;
		this.eage = eage;
		this.gender = gender;
		this.projectid = projectid;
		this.no_of_Day = no_of_Day;
		this.wages = wages;
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
	public String getEage() {
		return eage;
	}
	public void setEage(String eage) {
		this.eage = eage;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public int getNo_of_Day() {
		return no_of_Day;
	}
	public void setNo_of_Day(int no_of_Day) {
		this.no_of_Day = no_of_Day;
	}
	public int getWages() {
		return wages;
	}
	public void setWages(int wages) {
		this.wages = wages;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", gender=" + gender + ", projectid="
				+ projectid + ", no_of_Day=" + no_of_Day + ", wages=" + wages + "]";
	}
    
	
    
}
