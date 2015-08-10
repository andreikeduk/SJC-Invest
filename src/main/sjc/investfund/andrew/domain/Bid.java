package sjc.investfund.andrew.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bid")
public class Bid {
	@Id
	@GeneratedValue
	@Column(name = "id_bid")
	private Integer idBid;
	@Column(name = "name_bid")
	private String nameBid;
	@Column(name = "description")
	private String description;
	@Column(name = "amount")
	private Integer amount;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	@OneToOne
	@JoinColumn(name = "id_account")
	private Account account;
	
	public Bid() {
	}

	public Bid(Integer idBid, String nameBid, String description,
			Integer amount, User user, Account account) {
		this.idBid = idBid;
		this.nameBid = nameBid;
		this.description = description;
		this.amount = amount;
		this.user = user;
		this.account = account;
	}

	public Integer getIdBid() {
		return idBid;
	}

	public void setIdBid(Integer idBid) {
		this.idBid = idBid;
	}

	public String getNameBid() {
		return nameBid;
	}

	public void setNameBid(String nameBid) {
		this.nameBid = nameBid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
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
