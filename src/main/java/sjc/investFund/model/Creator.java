package sjc.investFund.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Creator")
public class Creator extends User {

}
