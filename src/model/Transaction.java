package model;

public class Transaction {

	private String to_id;
	private String transactiondescription;
	private String transactiondate;
	private double transactionamount;
	private double acountbalance;
	private String from_id;
	
	public Transaction() {
		
	}
	
	public String getFrom_id() {
		return from_id;
	}
	public void setFrom_id(String from_id) {
		this.from_id = from_id;
	}
	public String getTo_id() {
		return to_id;
	}
	public void setTo_id(String to_id) {
		this.to_id = to_id;
	}
	public String getTransactiondescription() {
		return transactiondescription;
	}
	public void setTransactiondescription(String transactiondescription) {
		this.transactiondescription = transactiondescription;
	}
	public String getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
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

}
