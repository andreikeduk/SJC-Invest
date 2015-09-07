package sjc.investFund.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DIRECTOR")
public class Director extends User {

	public Director() {

	}

	public Director(User user) {
		this.setEmail(user.getEmail());
		this.setFirstName(user.getFirstName());
		this.setId(user.getId());
		this.setLastName(user.getLastName());
		this.setLogin(user.getLogin());
		this.setPassword(user.getPassword());
		
	}
}
