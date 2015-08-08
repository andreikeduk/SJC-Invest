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
@Table(name = "Comments")
public class CommentEntity {
	@Id
	@GeneratedValue
	@Column(name = "idComment")
	private Long idComment;
	@Column(name = "comment")
	private String comment;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUser")
	private UserEntity user;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idBid")
	private BidEntity bid;

	public Long getIdComment() {
		return idComment;
	}

	public void setIdComment(Long idComment) {
		this.idComment = idComment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public BidEntity getBid() {
		return bid;
	}

	public void setBid(BidEntity bid) {
		this.bid = bid;
	}
}
