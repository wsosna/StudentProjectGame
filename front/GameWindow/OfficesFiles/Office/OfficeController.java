package front.GameWindow.OfficesFiles.Office;

import backend.employees.Employee;
import backend.employees.ExclusiveEmployee;
import backend.employees.NormalEmployee;
import backend.offices.Office;
import backend.wallet.Wallet;
import front.GameWindow.Employees.Exclusive.ExclusiveEmplController;
import front.GameWindow.Employees.Normal.Hired.HiredEmployee;
import front.GameWindow.Employees.Exclusive.Hired.HiredExclEmployeeController;
import front.GameWindow.Employees.Normal.NormalEmplController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class OfficeController {
    private Office office;
    @FXML
    GridPane gridPane;


    public OfficeController(Office office){
          this.office = office;
    }

    public void initialize() {
        loadNormalEmployee(0, 0);
        loadNormalEmployee(1, 0);
        loadNormalEmployee(2, 0);
        loadExclusiveEmployee(3,0);
    }

//    public void actEmpl1() {
//        System.out.println("kliknelo przed");
//        if(isEnoughtMoney(NormalEmployee.SALARY)) {
//            System.out.println("kliknelo po ifie");
//            hireNormalEmployee(0, 0);
//        }
//        else showAlertMessage();
//    }
//    public void actEmpl2() {
//        if(isEnoughtMoney(NormalEmployee.SALARY))
//            hireNormalEmployee(1, 0);
//        else showAlertMessage();
//    }
//    public void actEmpl3() {
//        if(isEnoughtMoney(NormalEmployee.SALARY))
//            hireNormalEmployee(2, 0);
//        else showAlertMessage();
//    }
//    public void ekslEmpl() {
//        if(isEnoughtMoney(ExclusiveEmployee.SALARY))
//            hireExclusiveEmployee(3, 0);
//        else showAlertMessage();
//    }

    public void hireNormalEmployee(int column, int row) {
        office.hire(new NormalEmployee());
        //loadHiredEmployee(column, row);
    }

    public void hireExclusiveEmployee(int column, int row) {
        office.hire(new ExclusiveEmployee());
        //loadExclusiveEmployee(column, row);
    }

    public void showAlertMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Nie stać Cię na tego pracownika!!!");
        alert.setTitle("Brak środków");
        alert.show();
    }

    public boolean isEnoughtMoney(int money) {
        return Wallet.getInstance().getBankBalance() >= money;
    }

    public void loadHiredEmployee(int column, int row) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HiredEmployee.fxml"));
        HiredEmployee controller = new HiredEmployee();
        loader.setController(controller);
        try {
            Pane pane = loader.load();
            gridPane.add(pane, column, row);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadHiredExclEmployee(int column, int row) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HiredExclEmployee.fxml"));
        HiredExclEmployeeController controller = new HiredExclEmployeeController();
        loader.setController(controller);
        try {
            Pane pane = loader.load();
            gridPane.add(pane, column, row);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadNormalEmployee(int column, int row) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../Employees/Normal/NormalEmpl.fxml"));
        NormalEmplController controller = new NormalEmplController(office);
        loader.setController(controller);
        try {
            Pane pane = loader.load();
            gridPane.add(pane, column, row);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadExclusiveEmployee(int column, int row) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../Employees/Exclusive/ExclusiveEmpl.fxml"));
        ExclusiveEmplController controller = new ExclusiveEmplController(office);
        loader.setController(controller);
        try {
            Pane pane = loader.load();
            gridPane.add(pane, column, row);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
