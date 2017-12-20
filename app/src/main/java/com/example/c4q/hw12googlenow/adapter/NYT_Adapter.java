package com.example.c4q.hw12googlenow.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private static final String TAG = "HELP!!!!";

    public NYT_Adapter(List<NYT_TopStories.Results> topStoriesList){
        this.topStoriesList = topStoriesList;
    }

    @Override
    public NYT_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nyt_itemview, parent, false);

        return new NYT_ViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(final NYT_ViewHolder holder, final int position) {
        NYT_TopStories.Results nyt_topStories = topStoriesList.get(position);
        holder.onBind(nyt_topStories);

        holder.article_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = topStoriesList.get(position).getUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                holder.itemView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return topStoriesList.size();
    }
}
