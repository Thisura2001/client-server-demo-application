package org.example.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerController {

    @FXML
    private TextArea AreaServer;

    @FXML
    private AnchorPane rootServer;

    @FXML
    private JFXTextField txtFieldServer;

    ServerSocket serverSocket;
    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;

    public void initialize(){
        new Thread(()->{

            try {
                serverSocket = new ServerSocket(3000);
                AreaServer.appendText("Server Started..");
                socket = serverSocket.accept();
                AreaServer.appendText("\nClient Connected...");

                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());

                String request = "";
                String response = "";

                while (!request.equals("finish")){
                    request = dataInputStream.readUTF();
                    AreaServer.appendText("\nClient: "+request);
                    txtFieldServer.clear();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @FXML
    void ServerSendButtonOnAction(ActionEvent event) throws IOException {
        dataOutputStream.writeUTF(txtFieldServer.getText());
        dataOutputStream.flush();
    }
}
