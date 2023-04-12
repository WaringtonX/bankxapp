package model;

public class Transaction {

	private String transactionid;
	private String transactiondate;
	private double transactionamount;
	private double acountbalance;
	private double credit;
	private String account_id;
	private String user_id;
	private String transactiondescription;
	
	public Transaction(String transactionid, String transactiondate, double transactionamount, double acountbalance,double credit,
			String account_id, String user_id, String transactiondescription) {
		super();
		this.transactionid = transactionid;
		this.transactiondate = transactiondate;
		this.transactionamount = transactionamount;
		this.acountbalance = acountbalance;
		this.credit = credit;
		this.account_id = account_id;
		this.user_id = user_id;
		this.transactiondescription = transactiondescription;
	}

	public Transaction() {
		
	}
	
	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public String getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}

	public String getTransactiondescription() {
		return transactiondescription;
	}

	public void setTransactiondescription(String transactiondescription) {
		this.transactiondescription = transactiondescription;
	}

	public double getTransactionamount() {
		return transactionamount;
	}

	public void setTransactionamount(double transactionamount) {
		this.transactionamount = transactionamount;
	}

	public double getAcountbalance() {
		return acountbalance;
	}

	public void setAcountbalance(double acountbalance) {
		this.acountbalance = acountbalance;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	

}
