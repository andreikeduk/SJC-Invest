package sjc.investFund.domain.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("POPULARITY")
public class Popularity extends Feedback{
	
	@Column(name = "popularity")
	private boolean popularity;

	public Popularity() {
		
	}

	public boolean getPopularity() {
		return popularity;
	}

	public void setPopularity(boolean popularity) {
		this.popularity = popularity;
	}
	
}
