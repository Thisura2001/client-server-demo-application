package org.example.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/View/Server.fxml"))));
        stage.setTitle("Server");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
