package sjc.investFund.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
@DiscriminatorValue("TRANSFER")
public class Transfer extends Transaction {
	
	@JoinColumn(name = "numbertransfer")
	private String numbertransfer;
	
	public Transfer() {

	}

	public Transfer(Transaction transaction) {
		this.setId(transaction.getId());
		this.setTime(transaction.getTime());
		this.setAmount(transaction.getAmount());
		this.setInvestorAccount(transaction.getInvestorAccount());
		this.setGoalAccount(transaction.getGoalAccount());
	}

	public String getNumbertransfer() {
		return numbertransfer;
	}

	public void setNumbertransfer(String numbertransfer) {
		this.numbertransfer = numbertransfer;
	}
}
