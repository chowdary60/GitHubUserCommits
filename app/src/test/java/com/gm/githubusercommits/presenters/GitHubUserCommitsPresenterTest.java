package com.gm.githubusercommits.presenters;

/**
 * Created by madhu on 5/12/19.
 */

import com.gm.githubusercommits.contracts.GitHubUserCommitsContract;
import com.gm.githubusercommits.models.GitHubCommit;
import com.gm.githubusercommits.repository.GitHubUserCommitsRepository;
import com.gm.githubusercommits.repository.GitHubUserCommitsService;
import com.gm.githubusercommits.util.NetworkManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class GitHubUserCommitsPresenterTest {

    @Mock
    GitHubUserCommitsContract.View view;

    @Mock
    GitHubUserCommitsRepository service;

    @Mock
    NetworkManager networkManager;

    GitHubUserCommitsPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new GitHubUserCommitsPresenter(view, service, networkManager);
    }

    @Test
    public void noInternetAccess() {
        presenter.onStart();
        Mockito.when(networkManager.isInternetConnectionAvailable()).thenReturn(false);
        Mockito.verify(view).connectionNotAvailable();
    }

    @Test
    public void getUserCommitsSuccess() {
        Mockito.when(networkManager.isInternetConnectionAvailable()).thenReturn(true);
        presenter.onStart();
        Mockito.verify(view).showProgressDialog();
        ArgumentCaptor<GitHubUserCommitsService.GitHubUserCommitsCallback> captor = ArgumentCaptor.forClass(GitHubUserCommitsService.GitHubUserCommitsCallback.class);
        Mockito.verify(service).getUserCommits(captor.capture());
        captor.getValue().onSuccess(new ArrayList<GitHubCommit>());
        Mockito.verify(view).hideProgressDialog();
        Mockito.verify(view).processResponse(Mockito.<GitHubCommit>anyList());
    }

    @Test
    public void getUserCommitsFailure() {
        Mockito.when(networkManager.isInternetConnectionAvailable()).thenReturn(true);
        presenter.onStart();
        Mockito.verify(view).showProgressDialog();
        ArgumentCaptor<GitHubUserCommitsService.GitHubUserCommitsCallback> captor = ArgumentCaptor.forClass(GitHubUserCommitsService.GitHubUserCommitsCallback.class);
        Mockito.verify(service).getUserCommits(captor.capture());
        captor.getValue().onError(new Throwable());
        Mockito.verify(view).hideProgressDialog();
        Mockito.verify(view).processError(Mockito.any(Throwable.class));
    }

    @After
    public void tearDown() throws Exception {
        presenter = null;
    }
}