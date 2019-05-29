package Model;

public class User2 {
	private int MaUser;
	private String TenUser;
	private String email;
	private String sdt;
	private String pass;
	
	
	public User2(String tenUser, String email, String sdt, String pass) {
		super();
		TenUser = tenUser;
		this.email = email;
		this.sdt = sdt;
		this.pass = pass;
	}


	public User2(int maUser, String tenUser, String email, String sdt, String pass) {
		super();
		MaUser = maUser;
		TenUser = tenUser;
		this.email = email;
		this.sdt = sdt;
		this.pass = pass;
	}


	public String getSdt() {
		return sdt;
	}

	public User2(int maUser, String tenUser, String email, String pass) {
		super();
		MaUser = maUser;
		TenUser = tenUser;
		this.email = email;
		this.pass = pass;
	}
	
	
	public User2() {
		super();
	}


	public User2(String tenUser, String email, String pass) {
		super();
		TenUser = tenUser;
		this.email = email;
		this.pass = pass;
	}
	//kết thúc Constructor

	public int getMaUser() {
		return MaUser;
	}


	public void setMaUser(int maUser) {
		MaUser = maUser;
	}


	public String getTenUser() {
		return TenUser;
	}


	public void setTenUser(String tenUser) {
		TenUser = tenUser;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

}
