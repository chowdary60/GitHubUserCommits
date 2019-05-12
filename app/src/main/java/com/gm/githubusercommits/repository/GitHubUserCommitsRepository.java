package com.gm.githubusercommits.repository;

/**
 * Created by madhu on 5/12/19.
 */

public class GitHubUserCommitsRepository implements GitHubUserCommitsService {

    private GitHubUserCommitsServiceImpl gitHubUserCommitsRepository;

    public GitHubUserCommitsRepository(GitHubUserCommitsServiceImpl gitHubUserCommitsRepository) {
        this.gitHubUserCommitsRepository = gitHubUserCommitsRepository;
    }
}