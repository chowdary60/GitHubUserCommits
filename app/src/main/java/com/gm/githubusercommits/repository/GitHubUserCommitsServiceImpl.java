package com.gm.githubusercommits.repository;

import com.gm.githubusercommits.models.GitHubCommit;
import com.gm.githubusercommits.retrofit.GitHubUserCommitsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by madhu on 5/12/19.
 */

public class GitHubUserCommitsServiceImpl implements GitHubUserCommitsService {
    private GitHubUserCommitsApi gitHubUserCommitsApi;

    public GitHubUserCommitsServiceImpl(GitHubUserCommitsApi gitHubUserCommitsApi) {
        this.gitHubUserCommitsApi = gitHubUserCommitsApi;
    }
    @Override
    public void getUserCommits(final GitHubUserCommitsService.GitHubUserCommitsCallback gitHubUserCommitsCallback) {
        gitHubUserCommitsApi.getUserCommits().enqueue(new Callback<List<GitHubCommit>>() {
            @Override
            public void onResponse(Call<List<GitHubCommit>> call, Response<List<GitHubCommit>> response) {
                gitHubUserCommitsCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<GitHubCommit>> call, Throwable t) {
                gitHubUserCommitsCallback.onError(t);
            }
        });
    }
}
