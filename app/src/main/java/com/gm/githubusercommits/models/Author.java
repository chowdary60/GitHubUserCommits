package com.gm.githubusercommits.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by madhu on 5/11/19.
 */

public class Author {
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
