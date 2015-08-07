package Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Projects")
public class ProjectEntity {
	@Id
	@Column(name = "idProject")
	private Long idProject;
	@Column(name = "projectDescription")
	private String projectDescription;
	@Column(name = "statusProject")
	private boolean statusProject;
	@Column(name = "deadline")
	private Date deadline;
	@Column(name = "popularity")
	private int popularity;
	@Column(name = "projectAccount")
	private int projectAccount;
	@Column(name = "balance")
	private int balance;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idBid")
	private BidEntity bid;

	public Long getIdProject() {
		return idProject;
	}

	public void setIdProject(Long idProject) {
		this.idProject = idProject;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public boolean isStatusProject() {
		return statusProject;
	}

	public void setStatusProject(boolean statusProject) {
		this.statusProject = statusProject;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public int getProjectAccount() {
		return projectAccount;
	}

	public void setProjectAccount(int projectAccount) {
		this.projectAccount = projectAccount;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public BidEntity getBid() {
		return bid;
	}

	public void setBid(BidEntity bid) {
		this.bid = bid;
	}
}
