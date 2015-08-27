package sjc.investFund.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("POPULARITY")
public class Popularity extends Feedback{
	
	@Column(name = "popularity")
	private boolean popularity;

	
}
