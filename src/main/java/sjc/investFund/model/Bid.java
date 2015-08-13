package sjc.investFund.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Date periodConsideration;
	@Column(name = "status")
	private String status;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id")
	private Project project;

	public Bid() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPeriodConsideration() {
		return periodConsideration;
	}

	public void setPeriodConsideration(Date periodConsideration) {
		this.periodConsideration = periodConsideration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
