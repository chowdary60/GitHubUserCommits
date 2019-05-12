package com.gm.githubusercommits.views;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.Group;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gm.githubusercommits.GitHubUserCommitsApplication;
import com.gm.githubusercommits.R;
import com.gm.githubusercommits.contracts.GitHubUserCommitsContract;
import com.gm.githubusercommits.models.GitHubCommit;
import com.gm.githubusercommits.presenters.GitHubUserCommitsPresenter;
import com.gm.githubusercommits.repository.GitHubUserCommitsRepository;
import com.gm.githubusercommits.util.NetworkManager;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by madhu on 5/12/19.
 */
/*
Activity class which is responsible for the Rendenring UI and interact witht the presenter
 */
public class GitHubUserCommitsActivity extends AppCompatActivity implements GitHubUserCommitsContract.View {

    @Inject
    GitHubUserCommitsRepository gitHubUserCommitsRepository;

    @Inject
    NetworkManager networkManager;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_user_commits);

        GitHubUserCommitsApplication gitHubUserCommitsApplication = (GitHubUserCommitsApplication) getApplication();
        gitHubUserCommitsApplication.getComponent().inject(this);
        new GitHubUserCommitsPresenter(this, gitHubUserCommitsRepository, networkManager).onStart();
    }

    @Override
    public void processResponse(List<GitHubCommit> response) {
        RecyclerView recyclerView = findViewById(R.id.rv_user_commits);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GitHubUserCommitsAdapter gitHubUserCommitsAdapter = new GitHubUserCommitsAdapter(response);
        recyclerView.setAdapter(gitHubUserCommitsAdapter);

    }

    @Override
    public void processError(Throwable exception) {
        Toast.makeText(this, "Commits Retrieval Failed with", Toast.LENGTH_LONG).show();
    }

    @Override
    public void connectionNotAvailable() {
       Toast.makeText(this,"Network connection not available,please check it once",Toast.LENGTH_LONG).show();
    }
}
