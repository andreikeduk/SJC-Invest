package sjc.investFund.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("INVESTOR")
public class Investor extends User {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Account account;

	public Investor() {
	}

	public Investor(User user) {
		this.setEmail(user.getEmail());
		this.setFirstName(user.getFirstName());
		this.setId(user.getId());
		this.setLastName(user.getLastName());
		this.setLogin(user.getLogin());
		this.setPassword(user.getPassword());		
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
