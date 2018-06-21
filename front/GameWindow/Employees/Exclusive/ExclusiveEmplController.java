package front.GameWindow.Employees.Exclusive;

import backend.employees.ExclusiveEmployee;
import backend.offices.Office;
import backend.wallet.Wallet;
import front.GameWindow.Employees.Exclusive.Hired.HiredExclEmployeeController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ExclusiveEmplController {
    @FXML
    Button button;
    @FXML
    Pane pane;
    private Office office;

    public ExclusiveEmplController(Office office) {
        this.office = office;
    }

    public void initialize() {
        button.textProperty().set("5$/s -150$");
    }

    @FXML
    public void hire() {
        if(isEnoughtMoney(ExclusiveEmployee.SALARY)) {
            loadHiredEmployee();
            office.hire(new ExclusiveEmployee());
        }
        else showAlertMessage();
    }

    public void showAlertMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Nie stać Cię na tego pracownika!!!");
        alert.setTitle("Brak środków");
        alert.show();
    }

    public void loadHiredEmployee() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../Employees/Exclusive/Hired/HiredExclEmployee.fxml"));
        HiredExclEmployeeController controller = new HiredExclEmployeeController();
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
