package sjc.domain.model;

import java.util.ArrayList;

public class Area {
	private TypeArea				typeArea;
	private ArrayList<BidProject>	projects;	//It may be not used. BidProject has a Area
	private Integer					balance;	//It may be not used. areaAccout is here.
	private Account					areaAccount;
	
	public Area(){}
	
	public Area(TypeArea typeArea, ArrayList<BidProject> projects,
			Integer balance, Account areaAccount) {
		
		this.typeArea = typeArea;
		this.projects = projects;
		this.balance = balance;
		this.areaAccount = areaAccount;
	}
	public TypeArea getTypeArea() {
		return typeArea;
	}
	public void setTypeArea(TypeArea typeArea) {
		this.typeArea = typeArea;
	}
	public ArrayList<BidProject> getProjects() {
		return projects;
	}
	public void setProjects(ArrayList<BidProject> projects) {
		this.projects = projects;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public Account getAreaAccount() {
		return areaAccount;
	}
	public void setAreaAccount(Account areaAccount) {
		this.areaAccount = areaAccount;
	}
}
