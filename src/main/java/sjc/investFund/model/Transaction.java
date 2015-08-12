package sjc.investFund.andrew.entity;

public class Transaction {
	Integer id;
	Date time;
	TypeTransaction type;
	Integer amount;
	Account investor;
	Account goal;
}
