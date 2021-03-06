package sjc.investFund.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Bids")
public class Bid {

	private final static Integer PERIOD_CONSIDERATION = 10;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "periodConsideration")
	private Calendar periodConsideration;
	@Enumerated(EnumType.STRING)
	private BidStatus status;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	private Project project;

	public Bid() {
	}

	public Bid(BidStatus status) {
		this.status = status;
		this.periodConsideration = Calendar.getInstance();
		this.periodConsideration
				.add(Calendar.DAY_OF_YEAR, PERIOD_CONSIDERATION);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getPeriodConsideration() {
		return periodConsideration;
	}

	public void setPeriodConsideration(Calendar periodConsideration) {
		this.periodConsideration = periodConsideration;
	}

	public BidStatus getStatus() {
		return status;
	}

	public void setStatus(BidStatus status) {
		this.status = status;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
