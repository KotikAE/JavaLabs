package com.example.javalabsv2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.Socket;

public class ClientModel {
    private Connection connection;
    private ClientModel user;
    private boolean isConnect = false;

    public boolean IsConnect(){
        return isConnect;
    }

    public void SetConnect(boolean connect){
        isConnect = connect;
    }
    private Controller mainController;
    private String username;
    public ClientModel(Controller controller){
        System.out.println("User created!");
        user = this;
        mainController = controller;

        ConnectToServer(); //соединяемся с сервером при входе пользователя
        UserThreat listener = new UserThreat(connection, controller);
        listener.start();
    }

    void ConnectToServer(){
        if(!isConnect){
            while(true){
                try{
                    Socket socket = new Socket("localhost",9999);
                    connection = new Connection(socket);
                    isConnect = true;
                    break;
                }catch (Exception e){

                }
            }
        }
    }

    public void StopConnection(){
        isConnect = false;
    }

//    public String GetUserName(){
//        return username;
//    }
//
//    void AddAccountToUser(String userName,int AccountID){
//        try {
//            System.out.println("Добавление аккаунта");
//            connection.Send(new Message(userName,AccountID));
//        }catch (Exception e){
//
//        }
//    }
//
//    void MakeTransition(String userName, int accountSenderID,int accountRecepientID,int transitValue){
//        try {
//            connection.Send(new Message(userName,accountSenderID,accountRecepientID,transitValue));
//        }catch (Exception e){
//
//        }
//    }
//
//    void AddMoneyOnAccount(int accountID,int addValue){
//        try {
//            connection.Send(new Message(accountID,addValue));
//        }catch (Exception e){
//
//        }
//    }
//
//    void WithdrawMoneyFromAccount(String user, int accountID,int withdrawWalue){
//        try {
//            connection.Send(new Message(user,accountID,withdrawWalue));
//        }catch (Exception e){
//
//        }
//    }
//
//    void BankAccountsRequest(){
//        try {
//            connection.Send(new Message(username,MessageType.GET_USER_ACCOUNTS));
//            System.out.println("Сообщение отправлено");
//        }catch (Exception e){
//
//        }
//    }


    void userTabSend(String inData) throws IOException {
        connection.Send(new Message(inData, MessageType.TAB_USER_REQUEST));
    }

    void gameStatsTabSend(String inData) throws IOException {
        connection.Send(new Message(inData, MessageType.TAB_GAMESCORE_REQUEST));
    }

    void genreTabSend() throws IOException {
        connection.Send(new Message(MessageType.TAB_GENRE_REQUEST));
    }


    class UserThreat extends Thread{
        private Connection connection;
        Controller appController;
        UserThreat(Connection connection,Controller appController){
            System.out.println("UserthreadCreated!");

            this.appController = appController;
            this.connection = connection;
        }

        @Override
        public void run(){
            while(user.IsConnect()){
                if(user.IsConnect()){
                    System.out.println("Reciving messeges...");
                    ReceiveMessageFromServer();
                }
            }
        }

        protected void ReceiveMessageFromServer() {
            while (isConnect) {
                try {
                    Message message = connection.Receive();

                    switch (message.GetMessageType()) {
                        case TAB_USER_RESPONSE -> {
                            appController.setUserTabData(message.GetAccountName(),message.GetIngameName(),message.GetAchievements(),message.GetGameStore());
                            break;
                        }
                        case TAB_GAMESCORE_RESPONSE -> {
                            appController.setGameStatsTabData(message.GetTotalTime(),message.GetSessionTime(),message.GetCurrentScore());
                            break;
                        }
                        case TAB_GENRE_RESPONSE -> {
                            appController.setGenreTabData(genreParse(message.GetGenreList()), tagParse(message.GetTagList()));
                            break;
                        }
                    }
                } catch (Exception e) {

                }
            }
        }
        ObservableList<String> genreParse(String inData) {
            String[] words = inData.split(" ");
            ObservableList<String> res = FXCollections.observableArrayList(words);
            return res;
        }
        ObservableList<String> tagParse(String inData) {
            String[] words = inData.split(" ");
            ObservableList<String> res = FXCollections.observableArrayList(words);
            return res;
        }
    }
}
