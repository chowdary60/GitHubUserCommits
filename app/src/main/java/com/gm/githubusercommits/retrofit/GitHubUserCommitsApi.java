package com.gm.githubusercommits.retrofit;

import com.gm.githubusercommits.models.GitHubCommit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by madhu on 5/12/19.
 */
/*
retrofit will be used to interact with github API
 */

public interface GitHubUserCommitsApi {

    @GET("repos/chowdary60/GitHubUserCommits/commits")
    Call<List<GitHubCommit>> getUserCommits();
}
