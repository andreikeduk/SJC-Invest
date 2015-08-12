package sjc.investFund.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@OneToMany
	@JoinColumn(name = "id")
	private Account investor;
	@ManyToOne
	@JoinColumn(name = "id")
	private Account goal;
	
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

	public Account getInvestor() {
		return investor;
	}

	public void setInvestor(Account investor) {
		this.investor = investor;
	}

	public Account getGoal() {
		return goal;
	}

	public void setGoal(Account goal) {
		this.goal = goal;
	}

	public Transaction() {
		super();
	}
	
	
	
}
