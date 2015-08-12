package sjc.investFund.andrew.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Creator")
public class Creator extends User {

}
