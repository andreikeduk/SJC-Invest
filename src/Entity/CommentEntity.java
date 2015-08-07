package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentEntity {
	@Id
	@Column(name = "comment_id")
	private Integer commentId;
}
