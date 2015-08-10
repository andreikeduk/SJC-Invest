package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Areas")
public class AreaEntity {
	@Id
	@GeneratedValue
	@Column(name = "idArea")
	private Long idArea;
	@Column(name = "areaName")
	private String areaName;
	@Column(name = "areaAccont")
	private int areaAccount;
	@Column(name = "areaBalance")
	private int areaBalance;

	public AreaEntity() {

	}

	public Long getIdArea() {
		return idArea;
	}

	public void setIdArea(Long idArea) {
		this.idArea = idArea;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getAreaAccount() {
		return areaAccount;
	}

	public void setAreaAccount(int areaAccount) {
		this.areaAccount = areaAccount;
	}

	public int getAreaBalance() {
		return areaBalance;
	}

	public void setAreaBalance(int areaBalance) {
		this.areaBalance = areaBalance;
	}
}
