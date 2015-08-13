package sjc.investFund.model;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Investor")
public class Investor extends User {
}
