package front.GameWindow.OfficesFiles.Office;

import backend.offices.Office;
import front.GameWindow.Employees.Exclusive.ExclusiveEmplController;
import front.GameWindow.Employees.Normal.NormalEmplController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
