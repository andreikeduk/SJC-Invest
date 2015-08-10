package sjc.domain.model;

import java.util.Date;

public class Transaction {
	private Date			time;
	private Integer			amount;
	private TypeTransaction	type;
	private Integer			investorAccount;
	private Integer			necessaryAccount;
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public TypeTransaction getType() {
		return type;
	}
	public void setType(TypeTransaction type) {
		this.type = type;
	}
	public Integer getInvestorAccount() {
		return investorAccount;
	}
	public void setInvestorAccount(Integer investorAccount) {
		this.investorAccount = investorAccount;
	}
	public Integer getNecessaryAccount() {
		return necessaryAccount;
	}
	public void setNecessaryAccount(Integer necessaryAccount) {
		this.necessaryAccount = necessaryAccount;
	}
}
