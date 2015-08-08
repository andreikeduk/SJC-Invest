package model;

import java.util.Date;

public class Bid {
	private Long idBid;
	private String name;
	private String description;
	private int requiredAmount;
	private Date periodConsideration;
	private String statusBid;
	private Area area;
	private Creator creator;

	public Long getIdBid() {
		return idBid;
	}

	public void setIdBid(Long idBid) {
		this.idBid = idBid;
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

	public int getRequiredAmount() {
		return requiredAmount;
	}

	public void setRequiredAmount(int requiredAmount) {
		this.requiredAmount = requiredAmount;
	}

	public Date getPeriodConsideration() {
		return periodConsideration;
	}

	public void setPeriodConsideration(Date periodConsideration) {
		this.periodConsideration = periodConsideration;
	}

	public String getStatusBid() {
		return statusBid;
	}

	public void setStatusBid(String statusBid) {
		this.statusBid = statusBid;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}
}
