package com.example.javalabsv2;

import java.util.ArrayList;
import java.util.List;

public class ServerModel {
    private List<User> userList = new ArrayList<User>();
    private List<Genre> genreList = new ArrayList<Genre>();

    public ServerModel() {
        GameScore<Integer> user1GameScore = new GameScore<>(3, 2, 1);
        PCUser user1 = new PCUser("qwe", "QwE", 1, "Steam", user1GameScore);

        GameScore<Integer> user2GameScore = new GameScore<>(4, 3, 2);
        PCUser user2 = new PCUser("rty", "RtY", 2, "EGS", user2GameScore);

        GameScore<Integer> user3GameScore = new GameScore<>(5, 4, 3);
        PCUser user3 = new PCUser("uio", "UiO", 3, "Origin", user3GameScore);

        GameScore<Integer> user4GameScore = new GameScore<>(6, 5, 4);
        PSUser user4 = new PSUser("asd", "AsD", 4, "PlayStation Store",user4GameScore);

        GameScore<Integer> user5GameScore = new GameScore<>(7, 6, 5);
        XBOXUser user5 = new XBOXUser("fgh", "FgH", 5, "Microsoft Store", user5GameScore);

        Genre genre = new Genre();
        genre.addGenre("Platformer");
        genre.addGenre("FPS");
        genre.addGenre("Adventure");
        genre.addGenre("RPG");

        genre.addTag("SP");
        genre.addTag("MP");
        genre.addTag("Crossplatform");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        genreList.add(genre);
    }

    public User checkIfExistsAndReturn (String inUserName) {
       for (int i = 0; i < userList.size(); i++) {
           if (userList.get(i).get_accountName().equals(inUserName))
               return userList.get(i);
       }
       return null;
    }

    public Genre getGenre () {
        return genreList.get(0);
    }
}
