package sjc.domain.model;

public class Feedback {
	private Integer	marks;
	private String	claim;
	private String	comment;
	
	public Feedback(){}
	
	public Feedback(Integer marks, String claim, String comment) {
		this.marks = marks;
		this.claim = claim;
		this.comment = comment;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public String getClaim() {
		return claim;
	}
	public void setClaim(String claim) {
		this.claim = claim;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
