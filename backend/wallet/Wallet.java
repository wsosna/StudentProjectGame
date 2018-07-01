package backend.wallet;

public final class Wallet {

    private volatile static Wallet instance;
    private int bankBalance;
    private int gain;

    private Wallet() {
        bankBalance = 1000;
    }

    public static Wallet getInstance() {
        if (instance == null) {
            synchronized (Wallet.class) {
                if (instance == null) {
                    instance = new Wallet();
                }
            }
        }
        return instance;
    }

    public synchronized void addMoneyToBankBalance(int money) {
        bankBalance += money;
    }

    public synchronized void subtractMoneyFromBankBalance(int money) {
        bankBalance -= money;
    }

    public synchronized int getBankBalance() {
        return bankBalance;
    }

}