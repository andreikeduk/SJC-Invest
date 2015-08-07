package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Creators")
public class CreatorEntity {
	@Id
	@Column(name = "idCreator")
	private Long idCreator;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUser")
	private UserEntity user;
}
