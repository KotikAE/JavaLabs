package com.example.javalabsv2;

import java.util.ArrayList;
import java.util.List;

public class Genre {
    
    private List<String> _genreList = new ArrayList<String>();
    private List<String> _tagList = new ArrayList<String>();

    public Genre() {
    }

    public Genre(String inGenreName, String inTagName) {
        this._genreList.add(inGenreName);
        this._tagList.add(inTagName);
    }

    public List<String> getGenreList() {
        return this._genreList;
    }

    public List<String> getTagList() {
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
