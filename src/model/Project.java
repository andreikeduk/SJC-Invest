package model;

import java.util.Date;

public class Project {
	private Long idProject;
	private String projectDescription;
	private boolean statusProject;
	private Date deadline;
	private int popularity;
	private int projectAccount;
	private int balance;
	private Bid bid;

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

	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

}
