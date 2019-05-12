package com.gm.githubusercommits;

import android.app.Application;

import com.gm.githubusercommits.dagger.component.DaggerGitHubUserCommitsComponent;
import com.gm.githubusercommits.dagger.component.GitHubUserCommitsComponent;
import com.gm.githubusercommits.dagger.modules.GitHubUserCommitsModule;

/**
 * Created by madhu on 5/12/19.
 */

public class GitHubUserCommitsApplication extends Application {
    private GitHubUserCommitsComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerGitHubUserCommitsComponent.
                builder().
                gitHubUserCommitsModule(new GitHubUserCommitsModule(getApplicationContext()))
                .build();
    }

    public GitHubUserCommitsComponent getComponent() {
        return component;
    }
}
