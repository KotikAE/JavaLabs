package com.example.javalabsv2;

public abstract class User implements MyInterface {
    
    private String _accountName;
    private String _ingameName;
    private int _achievements;
    protected String _platform;
    protected String _gameStore;
    private GameScore<Integer> _gameScore;

    public User() {
        this._accountName = "Guest";
        this._ingameName = "Guest";
        this._achievements = 0;
        this._platform = "Unknown";
        this._gameStore = "Unknown";
        this._gameScore = new GameScore(0, 0, 0);
    }

    public User(String inAccountName, String inIngameName, int inAchievements, String inPlatform, String inGameStore, GameScore<Integer> inGameScore) {
        this._accountName = inAccountName;
        this._ingameName = inIngameName;
        this._achievements = inAchievements;
        this._platform = inPlatform;
        this._gameStore = inGameStore;
        this._gameScore = inGameScore;
    }

    @Override
    public String get_accountName() {
        return _accountName;
    }
    
    @Override
    public String get_ingameName() {
        return _ingameName;
    }

    @Override
    public int get_achievements() {
        return _achievements;
    }

    @Override
    public String get_platform() {
        return _platform;
    }

    @Override
    public String get_gameStore() { return _gameStore; }

    @Override
    public GameScore<Integer> get_gameScore() { return _gameScore; }

    public void set_accountName(String inAccountName) {
        this._accountName = inAccountName;
    }

    public void set_ingameName(String inIngameName) {
        this._ingameName = inIngameName;
    }

    public void set_achievements(int inAchievements) {
        this._achievements = inAchievements;
    }

    abstract void set_gameStore(String inGameStore);

    public void set_gameScore(GameScore<Integer> _gameScore) { this._gameScore = _gameScore; }
}
