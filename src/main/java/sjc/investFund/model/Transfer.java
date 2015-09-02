package sjc.investFund.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TRANSFER")
public class Transfer extends Transaction {
	public Transfer() {

	}
	
	public Transfer(Transaction transaction) {

	}
}
