package sjc.domain.model;

import java.util.ArrayList;
import java.util.Date;

public class BidProject {
	private String		name;
	private String		description;
	private Boolean		status;
	private Integer		popularity;
	private Area		area;
	private Integer		requiredAmount;
	private Date		date;
	private Date		periodConsideration;
	private Account		projectAccount;
	private ArrayList<Feedback>		feedback;
	private ArrayList<Transaction>	transactions;
	private TypeReuest				typeRequest;
	private TypePriorityProject		priority;
	
	public	BidProject(){}
	
	public BidProject(String name, String description, Boolean status,
			Integer popularity, Area area, Integer requiredAmount, Date date,
			Date periodConsideration, Account projectAccount,
			ArrayList<Feedback> feedback, ArrayList<Transaction> transactions,
			TypeReuest typeRequest, TypePriorityProject priority) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.popularity = popularity;
		this.area = area;
		this.requiredAmount = requiredAmount;
		this.date = date;
		this.periodConsideration = periodConsideration;
		this.projectAccount = projectAccount;
		this.feedback = feedback;
		this.transactions = transactions;
		this.typeRequest = typeRequest;
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Integer getRequiredAmount() {
		return requiredAmount;
	}

	public void setRequiredAmount(Integer requiredAmount) {
		this.requiredAmount = requiredAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getPeriodConsideration() {
		return periodConsideration;
	}

	public void setPeriodConsideration(Date periodConsideration) {
		this.periodConsideration = periodConsideration;
	}

	public Account getProjectAccount() {
		return projectAccount;
	}

	public void setProjectAccount(Account projectAccount) {
		this.projectAccount = projectAccount;
	}

	public ArrayList<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(ArrayList<Feedback> feedback) {
		this.feedback = feedback;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public TypeReuest getTypeRequest() {
		return typeRequest;
	}

	public void setTypeRequest(TypeReuest typeRequest) {
		this.typeRequest = typeRequest;
	}

	public TypePriorityProject getPriority() {
		return priority;
	}

	public void setPriority(TypePriorityProject priority) {
		this.priority = priority;
	}
}
