package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "claims")
public class ClaimEntity {
	@Id
	@Column(name = "claim_id")
	private Integer claimId;

}
