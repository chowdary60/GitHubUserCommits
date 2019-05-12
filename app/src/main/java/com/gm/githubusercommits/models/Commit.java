package com.gm.githubusercommits.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by madhu on 5/11/19.
 */
/*
Model class representing the JSON response
 */

public class Commit {
    @SerializedName("author")
    private Author author;
    @SerializedName("message")
    private String message;
    @SerializedName("tree")
    private Tree tree;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    @Override
    public String toString() {
        return "Commit{" +
                "author=" + author +
                ", message='" + message + '\'' +
                ", tree=" + tree +
                '}';
    }
}
