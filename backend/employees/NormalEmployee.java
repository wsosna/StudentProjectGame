package backend.employees;


import backend.wallet.Wallet;

public class NormalEmployee
        extends Employee{

    public NormalEmployee() {
        super(50, 3);
        payEmployee();
    }

    @Override
    public void payEmployee() {
        Wallet.getInstance().subtractMoneyFromBankBalance(this.getSALARY());
    }
}
