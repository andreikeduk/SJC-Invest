package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Investors")
public class InvestorEntity {
	@Id
	@Column(name = "idInvestor")
	private Long id;
	@Column(name = "investorBalance")
	private int investorBalance;
	@Column(name = "investorAccount")
	private int investorAccount;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUser")
	private UserEntity user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getInvestorBalance() {
		return investorBalance;
	}

	public void setInvestorBalance(int investorBalance) {
		this.investorBalance = investorBalance;
	}

	public int getInvestorAccount() {
		return investorAccount;
	}

	public void setInvestorAccount(int investorAccount) {
		this.investorAccount = investorAccount;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
}
