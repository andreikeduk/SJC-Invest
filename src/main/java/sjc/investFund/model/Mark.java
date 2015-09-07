package sjc.investFund.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@DiscriminatorValue("MARK")
public class Mark extends Feedback {
	
	@NotNull(message = "Need  to enter mark")
	@Range(min=1, max=5, message = "Mark must be in diapason 1-5")	
	@Column(name = "mark")
	private Integer mark;

	public Mark() {

	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}
}
