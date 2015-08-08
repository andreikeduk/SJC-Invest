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
@Table(name = "Transactions")
public class TransactionEntity {
	@Id
	@GeneratedValue
	@Column(name = "idTransaction")
	private Long idTransaction;
	@Column(name = "time")
	private Date time;
	@Column(name = "typeTransaction")
	private String typeTransaction;
	@Column(name = "amount")
	private int amount;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProject")
	private ProjectEntity project;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idInvestor")
	private InvestorEntity investor;

	public Long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getTypeTransaction() {
		return typeTransaction;
	}

	public void setTypeTransaction(String typeTransaction) {
		this.typeTransaction = typeTransaction;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public InvestorEntity getInvestor() {
		return investor;
	}

	public void setInvestor(InvestorEntity investor) {
		this.investor = investor;
	}
}
