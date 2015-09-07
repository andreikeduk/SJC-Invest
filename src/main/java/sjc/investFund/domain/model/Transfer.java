package sjc.investFund.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

@Entity
@DiscriminatorValue("TRANSFER")
public class Transfer extends Transaction {

	@Pattern(regexp="\\d{6}", message = "Format of number of transfer's operation - 6 digits")
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
