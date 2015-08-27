package sjc.investFund.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "time")
	private Date time;
	@Enumerated(EnumType.STRING)
	private TypeTransaction type;
	@Column(name = "amount")
	private Integer amount;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "investor_account_id")
	private Account investorAccount;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "goal_account_id")
	private Account goalAccount;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
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

	public Transaction() {
		super();
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
	
	
	
}
