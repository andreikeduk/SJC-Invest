package sjc.investFund.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

@Entity
@DiscriminatorValue("DATACHEK")
public class Datachek extends Transaction {
	
	@Pattern(regexp="\\d{5}", message = "Format of number of chek's operation - 5 digits")
	@JoinColumn(name = "numberchek")
	private String numberchek;

	public Datachek() {

	}

	public Datachek(Transaction transaction) {
		this.setId(transaction.getId());
		this.setTime(transaction.getTime());
		this.setAmount(transaction.getAmount());
		this.setInvestorAccount(transaction.getInvestorAccount());
		this.setGoalAccount(transaction.getGoalAccount());
	}

	public String getNumberchek() {
		return numberchek;
	}

	public void setNumberchek(String numberchek) {
		this.numberchek = numberchek;
	}
}
