package front.GameWindow.OfficesFiles.BuyOffice;

import backend.locations.City;
import backend.offices.Office;
import backend.offices.OfficeImpl;
import backend.wallet.Wallet;
import front.GameWindow.OfficesFiles.Office.OfficeController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class BuyOffice {
    private City location;
    private VBox vBox;
    @FXML
    private Button buyOfficeButton;

    public BuyOffice(City location, VBox vBox) {
        this.location = location;
        this.vBox = vBox;
    }

    public void buyOffice() {
        if(Wallet.getInstance().getBankBalance() > 300) {
            Office office = new OfficeImpl(location);
            location.buyOffice(office);
            loadOffice(office);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Brak środków");
            alert.setTitle("Brak środków");
            alert.show();
        }
    }

    public void loadOffice(Office office) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Office/Office.fxml"));
        OfficeController controller = new OfficeController(office);
        loader.setController(controller);
        try {
            Pane pane = loader.load();
            vBox.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
