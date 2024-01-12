package org.example.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/View/Client.fxml"))));
        stage.setTitle("Client");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
