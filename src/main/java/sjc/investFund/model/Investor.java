package sjc.investFund.andrew.entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Investor")
public class Investor extends User {
	
}
