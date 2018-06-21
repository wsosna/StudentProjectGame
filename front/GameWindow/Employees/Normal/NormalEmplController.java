package front.GameWindow.Employees.Normal;

import backend.employees.NormalEmployee;
import backend.offices.Office;
import backend.wallet.Wallet;
import front.GameWindow.Employees.Normal.Hired.HiredEmployee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class NormalEmplController {
    @FXML
    Button button;
    @FXML
    Pane pane;
    private Office office;

    public NormalEmplController(Office office) {
        this.office = office;
    }

    public void initialize() {
        button.textProperty().set("3$/s -50$");
    }

    @FXML
    public void hireEmployee() {
        if(isEnoughtMoney(NormalEmployee.SALARY)) {
            loadHiredEmployee();
            office.hire(new NormalEmployee());
        }
        else showAlertMessage();
    }

    public void showAlertMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Nie stać Cię na tego pracownika!!!");
        alert.setTitle("Brak środków");
        alert.show();
    }

    public void loadHiredEmployee() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../Employees/Normal/Hired/HiredEmployee.fxml"));
        HiredEmployee controller = new HiredEmployee();
        loader.setController(controller);
        try {
            Pane newpane = loader.load();
            pane.getChildren().removeAll(button);
            pane.getChildren().add(newpane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isEnoughtMoney(int money) {
        return Wallet.getInstance().getBankBalance() >= money;
    }
}
