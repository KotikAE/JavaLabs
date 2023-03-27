package com.example.javalabsv2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private static boolean isServerRunning = false;

    public static void main(String[] args) {
        Server server = new Server();
        server.StartServer();
        while(true){
            if(isServerRunning){
                server.AcceptServer();
                isServerRunning =false;
            } else if (!isServerRunning) {
                break;
            }
        }
        server.StopServer();
    }

    private void StartServer(){             // запуск сервера
        try {
            serverSocket = new ServerSocket(9999);
            isServerRunning = true;

        }catch (Exception e){

        }
    }
    private void StopServer(){                      // остановка сервера
        try{
            if(serverSocket != null && !serverSocket.isClosed()){
                serverSocket.close();
            }
        }catch (Exception e){

        }
    }
    protected void AcceptServer(){
        while (true){
            try {
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
            } catch (IOException e) {

            }
        }
    }

    private class ServerThread extends Thread{
        private Socket socket;
        private boolean isRunning;
        private String username;

        public ServerThread(Socket socket){
            this.socket=socket;
            System.out.println(socket.getLocalAddress());
            isRunning = true;
        }
    }
}
