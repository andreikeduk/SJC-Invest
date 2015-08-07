package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bids")
public class BidEntity {
	@Id
	@Column(name = "idBid")
	private Integer bidId;
}
