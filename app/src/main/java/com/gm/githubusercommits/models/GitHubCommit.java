package com.gm.githubusercommits.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by madhu on 5/11/19.
 */
/*
Model class representing the JSON response
 */
public class GitHubCommit {
    @SerializedName("commit")
    private Commit commit;

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    @Override
    public String toString() {
        return "GitHubCommit{" +
                "commit=" + commit +
                '}';
    }
}
