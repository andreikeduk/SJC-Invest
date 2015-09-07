package sjc.investFund.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CREATOR")
public class Creator extends User {

	public Creator() {
	}

	public Creator(User user) {
		this.setEmail(user.getEmail());
		this.setFirstName(user.getFirstName());
		this.setId(user.getId());
		this.setLastName(user.getLastName());
		this.setLogin(user.getLogin());
		this.setPassword(user.getPassword());
		
	}

}
