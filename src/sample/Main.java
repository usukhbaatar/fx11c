package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Date;

public class Main extends Application {

    Stage mainWindow;
    Pane layout;
    Scene scene;

    Button clickMe;
    Label label;
    int counter;
    Button reset;

    Date startDate;

    @Override
    public void start(Stage primaryStage) {
        mainWindow = primaryStage;
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        mainWindow.setTitle("Click Me!");

        layout = new FlowPane();
        scene = new Scene(layout, 600, 400);
        counter = 0;

        label = new Label();
        label.setStyle("-fx-font-size: 20px;");
        label.setText("0");
        layout.getChildren().add(label);

        clickMe = new Button("Click Me!");
        clickMe.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (counter == 0) {
                    startDate = new Date();
                } else {
                    Date nowDate = new Date();
                    if (nowDate.getTime() - startDate.getTime() > 5000)
                        return;
                }
                counter++;
                label.setText("" + counter);
            }
        });
        layout.getChildren().add(clickMe);

        reset = new Button("Reset");
        reset.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                counter = 0;
                label.setText("" + counter);
            }
        });
        layout.getChildren().add(reset);

        mainWindow.setScene(scene);
        mainWindow.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
