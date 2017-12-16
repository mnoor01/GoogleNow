package com.example.c4q.hw12googlenow;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by c4q on 12/15/17.
 */

public class ParseArticle {
    @SerializedName("author")
    @Expose
    String author;
    @SerializedName("title")
    @Expose
    String title;

    public ParseArticle(String author, String title) {
        this.author = author;
        this.title = title;
    }
}
