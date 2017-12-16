package com.example.c4q.hw12googlenow;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by c4q on 12/12/17.
 */

public class BBCAdapter extends RecyclerView.Adapter<BBCViewHolder> {
    private List<BBCSport> articleList;

    public BBCAdapter(List<BBCSport> articleList) {
        this.articleList = articleList;
    }

    @Override
    public BBCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView= LayoutInflater.from(parent.getContext()).inflate(R.layout.bbc_itemview,parent,false);
        return new BBCViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(BBCViewHolder holder, int position) {
        holder.BindingArticlesIGuess(articleList.get(position));

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
