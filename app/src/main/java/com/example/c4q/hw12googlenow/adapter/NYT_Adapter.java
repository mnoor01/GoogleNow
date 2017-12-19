package com.example.c4q.hw12googlenow.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.hw12googlenow.R;
import com.example.c4q.hw12googlenow.model.NYT_TopStories;
import com.example.c4q.hw12googlenow.views.NYT_ViewHolder;

import java.util.List;

/**
 * Created by bobbybah on 12/18/17.
 */

public class NYT_Adapter extends RecyclerView.Adapter<NYT_ViewHolder> {

    public List<NYT_TopStories.Results> topStoriesList;


    public NYT_Adapter(List<NYT_TopStories.Results> topStoriesList){
        this.topStoriesList = topStoriesList;
    }

    @Override
    public NYT_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nyt_itemview, parent, false);

        return new NYT_ViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(NYT_ViewHolder holder, int position) {
        NYT_TopStories.Results nyt_topStories = topStoriesList.get(position);
        holder.onBind(nyt_topStories);
    }

    @Override
    public int getItemCount() {
        return topStoriesList.size();
    }
}
