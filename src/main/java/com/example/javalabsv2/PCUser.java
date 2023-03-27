package com.example.javalabsv2;

public class PCUser extends User {
    
    public PCUser() {
        super();
        this._platform = "PC";
    }

    public PCUser(String inAccountName, String inIngameName, int inAchievements, String inGameStore, GameScore<Integer> inGameScore)
    {
        super(inAccountName, inIngameName, inAchievements, "PC", inGameStore, inGameScore);
    }

    @Override
    public void set_gameStore(String inGameStore) {
        this._gameStore = inGameStore;
    }
}
