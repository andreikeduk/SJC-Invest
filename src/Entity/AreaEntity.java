package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "areas")
public class AreaEntity {
	@Id
	@Column(name = "area_id")
	private Integer areaId;
}
