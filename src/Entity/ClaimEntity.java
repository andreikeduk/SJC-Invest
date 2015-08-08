package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Claims")
public class ClaimEntity {
	@Id
	@GeneratedValue
	@Column(name = "idClaim")
	private Long idClaim;
	@Column(name = "claim")
	private String claim;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idBid")
	private BidEntity bid;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUser")
	private UserEntity user;

	public Long getIdClaim() {
		return idClaim;
	}

	public void setIdClaim(Long idClaim) {
		this.idClaim = idClaim;
	}

	public String getClaim() {
		return claim;
	}

	public void setClaim(String claim) {
		this.claim = claim;
	}

	public BidEntity getBid() {
		return bid;
	}

	public void setBid(BidEntity bid) {
		this.bid = bid;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
}
