package sjc.investFund.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
@DiscriminatorValue("BANKCARD")
public class Bankcard extends Transaction {
	@NotNull(message = "Need  to enter number of card's operation")
	@Range(min = 1, max = 5, message = "Mark must be in diapason 1-5")
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
