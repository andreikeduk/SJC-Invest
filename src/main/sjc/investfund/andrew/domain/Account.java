package sjc.investfund.andrew.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_account")
	private Integer idAccount;
	@Column(name = "balance")
	private Integer balance;
	@OneToOne
	private User user;
	@OneToOne
	@JoinColumn(name = "id_bid")
	private Bid bid;
	
	public Account(Integer idAccount, Integer balance, User user, Bid bid) {
		this.idAccount = idAccount;
		this.balance = balance;
		this.user = user;
		this.bid = bid;
	}

	public Account() {
	}

	public Integer getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}
	
	
	
}
