package sjc.investFund.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Projects")
public class Project { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Size(min = 3, max = 40, message = "Project name must be between 3 and 40 characters long.")
	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private Boolean status;
	@Digits(integer = 4, fraction = 0, message = "Only numbers")
	@NotNull(message = "You need to enter count of days.")
	@Column(name = "deadline")
	private Integer deadline;
	
	@Digits(integer = 6, fraction = 0, message = "Only numbers")
	@Min(value = 99, message = "Really?")
	@NotNull(message = "Need  to enter required amount")
	@Column(name = "requiredAmount")
	private Integer requiredAmount;

	@NotNull(message = "You need to choise an area.")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "area_id")
	private Area area;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Account account;

	public Project() {
	}
	
	public Project(Boolean status) {
		this.status = false;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
//	public String getStringStatus() {
//		String stringStatus;
//		if (status == true) {
//			stringStatus = "Project ready";
//		} else {
//			stringStatus = "Project not ready";
//		}
//		return stringStatus;
//	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getDeadline() {
		return deadline;
	}

	public void setDeadline(Integer deadline) {
		this.deadline = deadline;
	}

	public Integer getRequiredAmount() {
		return requiredAmount;
	}

	public void setRequiredAmount(Integer requiredAmount) {
		this.requiredAmount = requiredAmount;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
