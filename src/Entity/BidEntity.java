package Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Bids")
public class BidEntity {
	@Id
	@GeneratedValue
	@Column(name = "idBid")
	private Long idBid;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "requiredAmount")
	private int requiredAmount;
	@Column(name = "periodConsideration")
	private Date periodConsideration;
	@Column(name = "statusBid")
	private String statusBid;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idArea")
	private AreaEntity area;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCreator")
	private CreatorEntity creator;

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

	public AreaEntity getArea() {
		return area;
	}

	public void setArea(AreaEntity area) {
		this.area = area;
	}

	public CreatorEntity getCreator() {
		return creator;
	}

	public void setCreator(CreatorEntity creator) {
		this.creator = creator;
	}

}
