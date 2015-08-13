package sjc.investFund.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("like")
public class Popularity extends Feedback{
	
	@Column(name = "popularity")
	private boolean popularity;

	
}
