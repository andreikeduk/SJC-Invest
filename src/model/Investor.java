package model;

public class Investor extends User {
	private Long id;
	private int investorBalance;
	private int investorAccount;
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getInvestorBalance() {
		return investorBalance;
	}

	public void setInvestorBalance(int investorBalance) {
		this.investorBalance = investorBalance;
	}

	public int getInvestorAccount() {
		return investorAccount;
	}

	public void setInvestorAccount(int investorAccount) {
		this.investorAccount = investorAccount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}