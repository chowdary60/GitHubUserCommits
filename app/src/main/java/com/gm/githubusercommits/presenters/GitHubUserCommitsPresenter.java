package com.gm.githubusercommits.presenters;

import com.gm.githubusercommits.contracts.GitHubUserCommitsContract;
import com.gm.githubusercommits.models.GitHubCommit;
import com.gm.githubusercommits.repository.GitHubUserCommitsService;
import com.gm.githubusercommits.util.NetworkManager;

import java.util.List;

/**
 * Created by madhu on 5/12/19.
 */

/*
Presenter class which will be communicating with the model module to get the data  and updates the view
 */

public class GitHubUserCommitsPresenter  implements GitHubUserCommitsContract.Presenter {
    private final GitHubUserCommitsContract.View view;
    private final GitHubUserCommitsService gitHubUserCommitsService;
    private final NetworkManager networkManager;
    public GitHubUserCommitsPresenter(GitHubUserCommitsContract.View view,
                                      GitHubUserCommitsService gitHubUserCommitsService,
                                      NetworkManager networkManager) {
        this.view = view;
        this.gitHubUserCommitsService = gitHubUserCommitsService;
        this.networkManager = networkManager;
    }

    @Override
    public void onStart() {
        if(!networkManager.isInternetConnectionAvailable()) {
            view.connectionNotAvailable();
            return;
        }

        gitHubUserCommitsService.getUserCommits(new GitHubUserCommitsService.GitHubUserCommitsCallback() {
            @Override
            public void onSuccess(List<GitHubCommit> commits) {
                // on success you will recive list of commits.
                view.processResponse(commits);
            }

            @Override
            public void onError(Throwable throwable) {
                view.processError(throwable);
            }
        });
    }
}
