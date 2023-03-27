package com.example.javalabsv2;

import java.util.ArrayDeque;

public class Genre {
    
    private ArrayDeque<String> _genreList = new ArrayDeque<String>();
    private ArrayDeque<String> _tagList = new ArrayDeque<String>();

    public Genre() {
    }

    public Genre(String inGenreName, String inTagName) {
        this._genreList.add(inGenreName);
        this._tagList.add(inTagName);
    }

    public ArrayDeque<String> getGenreList() {
        return this._genreList;
    }

    public ArrayDeque<String> getTagList() {
        return this._tagList;
    }

    public void addGenre(String inGenreName) {
        this._genreList.add(inGenreName);
    }

    public void addTag(String inTagName) {
        this._tagList.add(inTagName);
    }

    public void removeGenre(String inGenreName) {
        this._genreList.remove(inGenreName);
    }

    public void removeTag(String inTagName) {
        this._tagList.remove(inTagName);
    }
}
