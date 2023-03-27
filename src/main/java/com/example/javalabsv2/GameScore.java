package com.example.javalabsv2;

public class GameScore<T extends Number> {
    
    private T _totalTimePlayed;
    private T _sessionTimePlayed;
    private T _currentScore;

    public GameScore() {
    }

    public GameScore(T inTotalTimePlayed, T inSessionTimePlayed, T inCurrentScore) {
        this._totalTimePlayed = inTotalTimePlayed;
        this._sessionTimePlayed = inSessionTimePlayed;
        this._currentScore = inCurrentScore;
    }

    public T get_totalTimePlayed() {
        return _totalTimePlayed;
    }

    public T get_sessionTimePlayed() {
        return _sessionTimePlayed;
    }

    public T get_currentScore() {
        return _currentScore;
    }

    public void set_totalTimePlayed(T inTotalTimePlayed) {
        this._totalTimePlayed = inTotalTimePlayed;
    }

    public void set_sessionTimePlayed(T inSessionTimePlayed) {
        this._sessionTimePlayed = inSessionTimePlayed;
    }

    public void set_currentScore(T inCurrentScore) {
        this._currentScore = inCurrentScore;
    }
}
