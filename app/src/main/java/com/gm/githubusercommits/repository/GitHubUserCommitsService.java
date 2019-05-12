package com.gm.githubusercommits.repository;

import com.gm.githubusercommits.models.GitHubCommit;

import java.util.List;

/**
 * Created by madhu on 5/12/19.
 */

public interface GitHubUserCommitsService {
    interface GitHubUserCommitsCallback {
        void onSuccess(List<GitHubCommit> commits);
        void onError(Throwable throwable);
    }

    void getUserCommits(GitHubUserCommitsCallback gitHubUserCommitsCallback);
}
