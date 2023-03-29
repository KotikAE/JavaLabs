package com.example.javalabsv2;

import java.io.Serializable;
import java.util.ArrayDeque;

public class Message implements Serializable {
    private MessageType messageType;

    //______________________
    private String userName;
    //________________________

    private String _accountName;
    private String _ingameName;
    private Integer _achievements;
    private String _gameStore;

    private Integer _totalTimePlayed;
    private Integer _sessionTimePlayed;
    private Integer _currentScore;

    private String _genreList ;
    private String _tagList;



    public Message(String userName,MessageType type){
        messageType = type;
        this.userName = userName;

        _accountName = "";
        _ingameName = "";
        _achievements = 0;
        _gameStore = "";

    }

    public Message(MessageType type){
        messageType = type;
        this.userName = "";

        _accountName = "";
        _ingameName = "";
        _achievements = 0;
        _gameStore = "";
    }

    public Message(MessageType type, Integer inTotalTime, Integer inSessionTime, Integer inCurrentScore){
        messageType = type;
        this.userName = "";

        _totalTimePlayed = inTotalTime;
        _sessionTimePlayed = inSessionTime;
        _currentScore = inCurrentScore;
    }

    public Message(MessageType type, String inGenreList, String inTagList){
        messageType = type;
        this.userName = "";

        _genreList = inGenreList;
        _tagList = inTagList;
    }

    public Message(MessageType type, String inAccountName, String inIngameName, Integer inAchievements, String inGameStore){
        messageType = type;
        this.userName = "";

        _accountName = inAccountName;
        _ingameName = inIngameName;
        _achievements = inAchievements;
        _gameStore = inGameStore;
    }

    public MessageType GetMessageType()     { return  messageType; }
    public String GetUserName()             { return userName; }
    public String GetAccountName()          { return _accountName; }
    public String GetIngameName()           { return _ingameName; }
    public Integer GetAchievements()        { return _achievements; }
    public String GetGameStore()            { return _gameStore; }
    public Integer GetTotalTime()           { return _totalTimePlayed; }
    public Integer GetSessionTime()         { return _sessionTimePlayed; }
    public Integer GetCurrentScore()        { return _currentScore; }
    public String GetGenreList()            { return _genreList; }
    public String GetTagList()              { return _tagList; }

}