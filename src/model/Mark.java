package model;

public class Mark {
	private Long idMark;
	private Bid bid;
	private int mark;

	public Long getIdMark() {
		return idMark;
	}

	public void setIdMark(Long idMark) {
		this.idMark = idMark;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}
}
