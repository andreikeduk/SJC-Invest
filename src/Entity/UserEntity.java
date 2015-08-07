package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
}
