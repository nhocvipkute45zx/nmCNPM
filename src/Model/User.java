package Model;

public class User {
	private String name;
	private String email;
	private String sdt;
	private String password;
	
	public User() {
		super();
	}

	public User( String name, String email, String sdt, String password) {
		super();
		this.name = name;
		this.email = email;
		this.sdt = sdt;
		this.password = password;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
