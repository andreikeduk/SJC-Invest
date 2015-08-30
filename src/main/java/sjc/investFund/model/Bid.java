package sjc.investFund.model;

import java.util.Calendar;
import java.util.Locale;

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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "periodConsideration")
	private Calendar periodConsideration;
	@Enumerated(EnumType.STRING)
	private BidStatus status;
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "project_id")
	private Project project;

	public Bid() {
		status = BidStatus.UNDER_CONSIDERATION;
		periodConsideration = Calendar.getInstance() ;
		periodConsideration.add(Calendar.DAY_OF_YEAR, 10);
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
