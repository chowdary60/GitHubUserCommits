package com.gm.githubusercommits.repository;

import com.gm.githubusercommits.retrofit.GitHubUserCommitsApi;

/**
 * Created by madhu on 5/12/19.
 */

public class GitHubUserCommitsServiceImpl {
    private GitHubUserCommitsApi gitHubUserCommitsApi;

    public GitHubUserCommitsServiceImpl(GitHubUserCommitsApi gitHubUserCommitsApi) {
        this.gitHubUserCommitsApi = gitHubUserCommitsApi;
    }
}
