package sjc.investFund.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Transactions")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "time")
	private Calendar time;
	
	@Column(name = "status")
	private Boolean status;
	
	@Min(value = 10, message = "Can you give more money for this project?")
	@Max(value = 500000, message = "You don't have that amount!!!")
	@NotNull(message = "Need  to enter amount")
	@Column(name = "amount")
	private Integer amount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "investor_account_id")
	private Account investorAccount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "goal_account_id")
	private Account goalAccount;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", updatable = false, insertable = false)
	private TypeTransaction type;

	public Transaction() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public TypeTransaction getType() {
		return type;
	}

	public void setType(TypeTransaction type) {
		this.type = type;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Account getInvestorAccount() {
		return investorAccount;
	}

	public void setInvestorAccount(Account investorAccount) {
		this.investorAccount = investorAccount;
	}

	public Account getGoalAccount() {
		return goalAccount;
	}

	public void setGoalAccount(Account goalAccount) {
		this.goalAccount = goalAccount;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
