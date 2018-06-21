package front.GameWindow;

import backend.locations.City;
import backend.wallet.Wallet;
import front.GameWindow.OfficesFiles.BuyOffice.BuyOffice;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class GameWindow {
    @FXML
    private VBox warVBox, lonVBox, tokVBox;
    @FXML
    private Tab warTab, lonTab, tokTab;
    @FXML
    private Label walletLabel;

    private City warsaw;
    private City london;
    private City tokyo;

    public GameWindow() {
        this.warsaw = new City("Warsaw");
        this.london = new City("Londyn");
        this.tokyo = new City("Tokyo");
    }

    public void loadBuyOffice(VBox vBox, City city) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OfficesFiles/BuyOffice/BuyOffice.fxml"));
        BuyOffice controller = new BuyOffice(city, vBox);
        loader.setController(controller);
        try {
            Pane pane = loader.load();
            vBox.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        warTab.textProperty().set(warsaw.getName());
        lonTab.textProperty().set(london.getName());
        tokTab.textProperty().set(tokyo.getName());

        loadBuyOffice(warVBox, warsaw);
        loadBuyOffice(lonVBox, london);
        loadBuyOffice(tokVBox, tokyo);

        walletLabel.textProperty().set(Wallet.getInstance().getBankBalance()+" $");
        earnMoney();
    }

    public void earnMoney() {
        Task<Integer> earnMoneyTask = new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                while (!isCancelled()) {
                    int money = warsaw.getCityGain() + london.getCityGain() + tokyo.getCityGain();
                    Wallet.getInstance().addMoneyToBankBalance(money);
                    updateMessage(Wallet.getInstance().getBankBalance()+" $");
                    Thread.sleep(1000);
                }
                return null;
            }

        };

        walletLabel.textProperty().bind(earnMoneyTask.messageProperty());

        Thread thread = new Thread(earnMoneyTask);
        thread.setDaemon(true);
        thread.start();

    }
}
