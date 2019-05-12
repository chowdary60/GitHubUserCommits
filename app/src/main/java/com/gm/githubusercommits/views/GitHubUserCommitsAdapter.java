package com.gm.githubusercommits.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gm.githubusercommits.R;
import com.gm.githubusercommits.models.GitHubCommit;

import java.util.List;

/**
 * Created by madhu on 5/12/19.
 */
/*
Adapter which will act as bridge to show the elements data  in recyclerview item.
 */

public class GitHubUserCommitsAdapter extends RecyclerView.Adapter<GitHubUserCommitsAdapter.ViewHolder> {

    public List<GitHubCommit> commitList;

    public GitHubUserCommitsAdapter(List<GitHubCommit> commitList) {
        this.commitList = commitList;
    }

    @NonNull
    @Override
    public GitHubUserCommitsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.github_user_commit_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GitHubUserCommitsAdapter.ViewHolder viewHolder, int position) {
        viewHolder.bind(commitList.get(position));
    }

    @Override
    public int getItemCount() {
        if(commitList == null) return 0;
        return commitList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, commitId, commitMessage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_user_name);
            commitId = itemView.findViewById(R.id.tv_commit_id);
            commitMessage = itemView.findViewById(R.id.tv_commit_message);
        }

        public void bind(GitHubCommit gitHubCommit) {
            name.setText(gitHubCommit.getCommit().getAuthor().getName());
            commitId.setText(itemView.getContext().getString(R.string.commit_id, gitHubCommit.getCommit().getTree().getSha()));
            commitMessage.setText(gitHubCommit.getCommit().getMessage());
        }
    }
}
