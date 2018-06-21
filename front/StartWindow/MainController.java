package front.StartWindow;

import front.GameWindow.GameWindow;
import front.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainController {
    @FXML
    private Button startButton;

    @FXML
    public void start() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../front/GameWindow/Game.fxml"));
        GameWindow controller = new GameWindow();
        loader.setController(controller);
        try {
            Pane pane = loader.load();
            Main.getPrimaryStage().setScene(new Scene(pane));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
