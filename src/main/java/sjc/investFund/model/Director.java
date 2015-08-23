package sjc.investFund.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DIRECTOR")
public class Director extends User {

}
