package sjc.investFund.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CREATOR")
public class Creator extends User {

	public Creator(){
		
	}
}
