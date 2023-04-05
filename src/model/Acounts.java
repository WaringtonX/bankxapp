package model;

public class Acounts {

	private String user_id;
	private int acount_number;
	private int acount_type;
	private double avialable;
	private double balance;
	private String acount_id;
	
	public Acounts() {
		
	}
	
	public Acounts(String user_id, int acount_number, int acount_type, double avialable, double balance,
			String acount_id) {
		super();
		this.user_id = user_id;
		this.acount_number = acount_number;
		this.acount_type = acount_type;
		this.avialable = avialable;
		this.balance = balance;
		this.acount_id = acount_id;
	}
	
	public String getAcount_id() {
		return acount_id;
	}
	public void setAcount_id(String acount_id) {
		this.acount_id = acount_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getAcount_number() {
		return acount_number;
	}
	public void setAcount_number(int acount_number) {
		this.acount_number = acount_number;
	}
	public int getAcount_type() {
		return acount_type;
	}
	public void setAcount_type(int acount_type) {
		this.acount_type = acount_type;
	}
	public double getAvialable() {
		return avialable;
	}
	public void setAvialable(double avialable) {
		this.avialable = avialable;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
