package com.gm.githubusercommits.contracts;

import com.gm.githubusercommits.models.GitHubCommit;

import java.util.List;

/**
 * Created by madhu on 5/12/19.
 */

public interface GitHubUserCommitsContract {
    public interface View {

        void processResponse(List<GitHubCommit> response);

        void processError(Throwable exception);

        void connectionNotAvailable();
    }

    public interface Presenter {
        void onStart();
    }
}
