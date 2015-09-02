package sjc.investFund.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
@DiscriminatorValue("BANKCARD")
public class Bankcard extends Transaction {
	
	@JoinColumn(name = "numberCard")
	private String numberCard;	
	
	public Bankcard() {

	}
	
	public Bankcard(Transaction transaction) {
		this.setId(transaction.getId());
		this.setTime(transaction.getTime());
		this.setAmount(transaction.getAmount());
		this.setInvestorAccount(transaction.getInvestorAccount());
		this.setGoalAccount(transaction.getGoalAccount());
	}

	public String getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}
}
