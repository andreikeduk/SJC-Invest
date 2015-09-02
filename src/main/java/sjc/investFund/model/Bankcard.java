package sjc.investFund.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BANKCARD")
public class Bankcard extends Transaction {
	public Bankcard() {

	}
	
	public Bankcard(Transaction transaction) {
		
	}
}
