package com.example.javalabsv2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class Client extends Application {
    private Connection connection;
    private boolean isConnected = false;
    public boolean IsConnected() {
        return isConnected;
    }
    public void SetConnection(boolean connect) {
        isConnected = connect;
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("mainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Main Window");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void ConnectToServer(){
        if(!isConnected){
            while(true){
                try{
                    Socket socket = new Socket("localhost",9999);
                    connection = new Connection(socket);
                    isConnected = true;
                    break;
                }catch (Exception e){

                }
            }
        }
    }
}