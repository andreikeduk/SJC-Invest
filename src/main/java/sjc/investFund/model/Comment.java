package sjc.investFund.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("comment")
public class Comment {
	
	@Column(name = "comment")
	private String comment;

	public Comment() {
		
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
