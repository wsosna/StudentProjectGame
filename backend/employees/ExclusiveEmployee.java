package backend.employees;


import backend.wallet.Wallet;

public class ExclusiveEmployee
        extends Employee{

    public ExclusiveEmployee() {
        super(150, 5);
        payEmployee();
    }

    @Override
    public void payEmployee() {
        Wallet.getInstance().subtractMoneyFromBankBalance(this.getSALARY());
    }
}
