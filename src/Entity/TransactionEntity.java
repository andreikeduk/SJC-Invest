package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class TransactionEntity {
	@Id
	@Column(name = "transaction_id")
	private Integer transactionId;
}
