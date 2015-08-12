package sjc.investFund.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("like")
public class Like {
	
	@Column(name = "like")
	private String like;

	public Like() {
		
	}
	
	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}
}
