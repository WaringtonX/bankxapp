package model;

public class Customer {
	
	private String user_id;
	private String first_name;
	private String last_name;
	private String email_acount;
	private String password;
	
	public Customer(String user_id, String first_name, String last_name, String email_acount, String password) {
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_acount = email_acount;
		this.password = password;
	}
	
	public Customer() {
		
	}
	
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail_acount() {
		return email_acount;
	}
	public void setEmail_acount(String email_acount) {
		this.email_acount = email_acount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	

}
