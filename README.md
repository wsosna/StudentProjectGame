# OfficeMenager - student project

### How it works?
At first you will see the start window. After you click the start button - the game will go on!
![Ups...](https://images90.fotosik.pl/126/4ff18b747d498ed1gen.png)

##### Game window
The game offers you three locations - Warsaw, London and Tokyo. You have 1000$ for beggining, the office cost 300$. When you have office, you can hire somebody. There are two classes of employees
- normal
- exclucive

The diferences betweend them are prices and gains. 

![Ups...](https://images90.fotosik.pl/126/164df05a5fa7d0c6.png)

There is one Task in GameWindow which adds gain to Wallet.

```Java
public void earnMoney() {
        Task<Integer> earnMoneyTask = () -> {
                while (!isCancelled()) {
                    int money = warsaw.getCityGain() + london.getCityGain() + tokyo.getCityGain();
                    Wallet.getInstance().addMoneyToBankBalance(money);
                    updateMessage(Wallet.getInstance().getBankBalance()+" $");
                    Thread.sleep(1000);
                }
                return null;
        };
        walletLabel.textProperty().bind(earnMoneyTask.messageProperty());
        Thread thread = new Thread(earnMoneyTask);
        thread.setDaemon(true);
        thread.start();
    }
```

I've made wallet according to Singleton pattern. 

```Java
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
```

In case you want to spend more money than you have, you'll see the alert
![Ups...](https://images89.fotosik.pl/126/4fdf727f3bc3106egen.png)
## Used:
- Java 8
- JavaFX
- CSS
- Singleton
