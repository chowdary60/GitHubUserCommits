package com.gm.githubusercommits.dagger.modules;

import android.content.Context;

import com.gm.githubusercommits.repository.GitHubUserCommitsRepository;
import com.gm.githubusercommits.repository.GitHubUserCommitsServiceImpl;
import com.gm.githubusercommits.retrofit.GitHubUserCommitsApi;
import com.gm.githubusercommits.util.NetworkManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by madhu on 5/12/19.
 */
@Module
public class GitHubUserCommitsModule {
    private Context context;

    public GitHubUserCommitsModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return context;
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor providesLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    GitHubUserCommitsApi providesGitHubUserCommitsApi(Retrofit retrofit) {
        return retrofit.create(GitHubUserCommitsApi.class);
    }

    @Provides
    @Singleton
    GitHubUserCommitsServiceImpl providesGitHubUserCommitService(GitHubUserCommitsApi gitHubUserCommitsApi) {
        return new GitHubUserCommitsServiceImpl(gitHubUserCommitsApi);
    }

    @Provides
    @Singleton
    GitHubUserCommitsRepository providesGitHubCommitRepository(GitHubUserCommitsServiceImpl gitHubUserCommitsService) {
        return new GitHubUserCommitsRepository(gitHubUserCommitsService);
    }

    @Provides
    @Singleton
    NetworkManager providesNetworkUtil(Context context) {
        return new NetworkManager(context);
    }
}
