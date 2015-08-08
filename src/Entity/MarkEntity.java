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
@Table(name = "Marks")
public class MarkEntity {
	@Id
	@GeneratedValue
	@Column(name = "idMark")
	private Long idMark;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idBid")
	private BidEntity bid;
	@Column(name = "mark")
	private int mark;

	public Long getIdMark() {
		return idMark;
	}

	public void setIdMark(Long idMark) {
		this.idMark = idMark;
	}

	public BidEntity getBid() {
		return bid;
	}

	public void setBid(BidEntity bid) {
		this.bid = bid;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
}
