package sjc.investFund.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DiscriminatorValue("COMMENT")
public class Comment extends Feedback {

	@NotEmpty(message = "Need  to enter comment")
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
