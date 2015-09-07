package sjc.investFund.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

@Entity
@DiscriminatorValue("BANKCARD")
public class Bankcard extends Transaction {

	@Pattern(regexp="\\d{7}", message = "Format of number of card's operation - 7 digits")
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
