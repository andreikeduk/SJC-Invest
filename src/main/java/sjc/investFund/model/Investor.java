package sjc.investFund.model;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Investor")
public class Investor extends User {
	@OneToOne
	@JoinColumn(name = "id")
	private Account account;
}
