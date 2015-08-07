package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marks")
public class MarkEntity {
	@Id
	@Column(name = "mark_id")
	private Integer markId;
}
