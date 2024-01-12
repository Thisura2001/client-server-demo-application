package org.example.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientController {

    @FXML
    private TextArea txtArea;
    @FXML
    private JFXTextField txtMassage;
    @FXML
    private AnchorPane rootClient;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    ServerSocket serverSocket;
    Socket socket;

    public void initialize() {
        new Thread(()->{
            try {
                socket = new Socket("localhost", 3000);
                txtArea.appendText("Client started...");
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String request = "";
                String response = "";

                while (!request.equals("finish")) {
                    dataOutputStream.writeUTF(request);
                    response = dataInputStream.readUTF();
                    txtArea.appendText("\nServer: "+response);
                    txtMassage.clear();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void btnSendOnAction(ActionEvent actionEvent) throws IOException {
        dataOutputStream.writeUTF(txtMassage.getText());
        dataOutputStream.flush();
    }
}
