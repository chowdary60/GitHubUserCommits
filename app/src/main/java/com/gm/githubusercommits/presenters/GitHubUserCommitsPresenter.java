package com.gm.githubusercommits.presenters;

import com.gm.githubusercommits.contracts.GitHubUserCommitsContract;
import com.gm.githubusercommits.models.GitHubCommit;
import com.gm.githubusercommits.repository.GitHubUserCommitsService;
import com.gm.githubusercommits.util.NetworkManager;

import java.util.List;

/**
 * Created by madhu on 5/12/19.
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
        view.showProgressDialog();
        gitHubUserCommitsService.getUserCommits(new GitHubUserCommitsService.GitHubUserCommitsCallback() {
            @Override
            public void onSuccess(List<GitHubCommit> commits) {
                view.hideProgressDialog();
                view.processResponse(commits);
            }

            @Override
            public void onError(Throwable throwable) {
                view.hideProgressDialog();
                view.processError(throwable);
            }
        });
    }
}
