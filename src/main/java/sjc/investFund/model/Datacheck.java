package sjc.investFund.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
@DiscriminatorValue("DATACHECK")
public class Datacheck extends Transaction {
	
	@JoinColumn(name = "numbercheck")
	private String numbercheck;
	
	public Datacheck() {

	}

	public Datacheck(Transaction transaction) {
		this.setId(transaction.getId());
		this.setTime(transaction.getTime());
		this.setAmount(transaction.getAmount());
		this.setInvestorAccount(transaction.getInvestorAccount());
		this.setGoalAccount(transaction.getGoalAccount());
	}

	public String getNumbercheck() {
		return numbercheck;
	}

	public void setNumbercheck(String numbercheck) {
		this.numbercheck = numbercheck;
	}
}
