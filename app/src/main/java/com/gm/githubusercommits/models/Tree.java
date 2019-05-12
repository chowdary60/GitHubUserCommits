package com.gm.githubusercommits.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by madhu on 5/11/19.
 */
/*
Model class representing the JSON response
 */
public class Tree {
    @SerializedName("sha")
    private String sha;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "sha='" + sha + '\'' +
                '}';
    }
}
