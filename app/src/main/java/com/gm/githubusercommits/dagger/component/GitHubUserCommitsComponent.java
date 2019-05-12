package com.gm.githubusercommits.dagger.component;

/**
 * Created by madhu on 5/12/19.
 */

import com.gm.githubusercommits.dagger.modules.GitHubUserCommitsModule;
import com.gm.githubusercommits.views.GitHubUserCommitsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {GitHubUserCommitsModule.class})
@Singleton
public interface GitHubUserCommitsComponent {
    void inject(GitHubUserCommitsActivity gitHubUserCommitsActivity);
}
