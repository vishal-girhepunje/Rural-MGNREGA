package com.Model;

public class GPM {
	
	private int gid;
	private String gname;
	private String gemail;
	private String gpassword;
	private String gmobile;
	private String gaddress;
	private int bdoid;
	
	public GPM() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public GPM(int gid, String gname, String gemail, String gpassword, String gmobile, String gaddress) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gemail = gemail;
		this.gpassword = gpassword;
		this.gmobile = gmobile;
		this.gaddress = gaddress;
	}



	public GPM(int gid, String gname, String gemail, String gpassword, String gmobile, String gaddress, int bdoid) {
		super();
		
		this.gid = gid;
		this.gname = gname;
		this.gemail = gemail;
		this.gpassword = gpassword;
		this.gmobile = gmobile;
		this.gaddress = gaddress;
		this.bdoid = bdoid;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGemail() {
		return gemail;
	}

	public void setGemail(String gemail) {
		this.gemail = gemail;
	}

	public String getGpassword() {
		return gpassword;
	}

	public void setGpassword(String gpassword) {
		this.gpassword = gpassword;
	}

	public String getGmobile() {
		return gmobile;
	}

	public void setGmobile(String gmobile) {
		this.gmobile = gmobile;
	}

	public String getGaddress() {
		return gaddress;
	}

	public void setGaddress(String gaddress) {
		this.gaddress = gaddress;
	}

	public int getBdoid() {
		return bdoid;
	}

	public void setBdoid(int bid) {
		this.bdoid = bid;
	}

	@Override
	public String toString() {
		return "Gpm [gid=" + gid + ", gname=" + gname + ", gemail=" + gemail + ", gpassword=" + gpassword + ", gmobile="
				+ gmobile + ", gaddress=" + gaddress + ", bdoid=" + bdoid + "]";
	}
	
	
	
	
	

}
