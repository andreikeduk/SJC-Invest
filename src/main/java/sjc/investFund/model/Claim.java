package sjc.investFund.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DiscriminatorValue("CLAIM")
public class Claim extends Feedback {
	
	@Size(min = 20, max = 250, message = "Claim must be in diapason 20-250")
	@Column(name = "claim")
	private String claim;

	public Claim() {

	}

	public String getClaim() {
		return claim;
	}

	public void setClaim(String claim) {
		this.claim = claim;
	}
}
