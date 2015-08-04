package sjc.domain.model;

public class Account {
	private Integer number;
	private Integer balance;
	
	public Account(){};
	
	public Account(Integer number, Integer balance) {
		this.number = number;
		this.balance = balance;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
}
