package sjc.investFund.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MARK")
public class Mark extends Feedback {

	@Column(name = "mark")
	private Integer mark;

	
	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}
}
