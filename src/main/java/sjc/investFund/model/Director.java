package sjc.investFund.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Director")
public class Director extends User {
	public Director() {

	}
}
