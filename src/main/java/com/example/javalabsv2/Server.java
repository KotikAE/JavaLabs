package com.example.javalabsv2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private static boolean isServerRunning = false;
    private ServerModel model;

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

        private void RequestAccept(Connection connection,String username){
            while (isRunning){
                try {

                    Message message = connection.Receive();

                    switch (message.GetMessageType()){
                        case TAB_USER_REQUEST -> {
                            User sendUser = model.checkIfExistsAndReturn(message.GetUserName());
                            connection.Send(new Message(MessageType.TAB_USER_RESPONSE, sendUser.get_accountName(),sendUser.get_ingameName(), sendUser.get_achievements(), sendUser.get_gameStore()));
                            break;
                        }case TAB_GAMESCORE_REQUEST -> {
                            User sendUser = model.checkIfExistsAndReturn(message.GetUserName());
                            connection.Send(new Message(MessageType.TAB_GAMESCORE_RESPONSE, sendUser.get_gameScore().get_totalTimePlayed(), sendUser.get_gameScore().get_sessionTimePlayed(), sendUser.get_gameScore().get_currentScore()));
                            break;
                        }case TAB_GENRE_REQUEST -> {
                            Genre sendGenre = model.getGenre();
                            connection.Send(new Message(MessageType.TAB_GENRE_RESPONSE, genreParse(), tagParse()));
                            break;
                        }
                    }
                } catch (Exception e){

                }
            }
        }
        String genreParse() {
            String res = "";
            for(int i = 0; i < model.getGenre().getGenreList().size(); i++) {
                res += model.getGenre().getGenreList().get(i).toString() + " ";
            }
            return res;
        }
        String tagParse() {
            String res = "";
            for(int i = 0; i < model.getGenre().getTagList().size(); i++) {
                res += model.getGenre().getTagList().get(i).toString() + " ";
            }
            return res;
        }
        @Override
        public void run(){
            try {
                Connection connection = new Connection(socket);

                //String username = AddUser(connection);
                //AddUser(connection);
                //RequestUserName(connection);
                RequestAccept(connection,username);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //Сюды запихать функцию обработки запросов
            for(int i=0;i<10;i++){
                System.out.println(i);
            }
            /*while(true){
                RequestAccept();
            }*/
        }
    }
}
