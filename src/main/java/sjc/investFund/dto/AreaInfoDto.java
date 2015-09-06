package sjc.investFund.dto;

import sjc.investFund.model.Area;

public class AreaInfoDto {
	private Long projectsCount;
	private Long balance;
	private Area area;
	
	
	public AreaInfoDto() {		
	}
	
	public AreaInfoDto(Area area, Long projectsCount, Long balance ) {	
		this.projectsCount = projectsCount;
		this.balance = balance;
		this.area = area;
	}

	public Long getProjectsCount() {
		return projectsCount;
	}
	public void setProjectsCount(Long projectsCount) {
		this.projectsCount = projectsCount;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	
	
}
