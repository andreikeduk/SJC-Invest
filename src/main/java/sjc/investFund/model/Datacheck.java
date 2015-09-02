package sjc.investFund.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DATACHECK")
public class Datacheck extends Transaction {
	public Datacheck() {

	}
	
	public Datacheck(Transaction transaction) {

	}
}
