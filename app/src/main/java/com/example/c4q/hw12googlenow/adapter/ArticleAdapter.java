package com.example.c4q.hw12googlenow.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c4q.hw12googlenow.R;
import com.example.c4q.hw12googlenow.SecondActivity;
import com.example.c4q.hw12googlenow.model.Articles;

/**
 * Created by c4q on 12/16/17.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private Articles[] articles;

    public ArticleAdapter(Articles[] articles) {
        this.articles = articles;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView= LayoutInflater.from(parent.getContext()).inflate(R.layout.articles_itemview,parent,false);
        return new ArticleViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        holder.onBind(articles[position]);

    }

    @Override
    public int getItemCount() {
        return articles.length;
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        private TextView articleTitle;
        private TextView articleAuthor;
        private TextView articleDescription;
        public ArticleViewHolder(View itemView) {
            super(itemView);
            articleTitle =itemView.findViewById(R.id.articleTitle);
            articleAuthor=itemView.findViewById(R.id.articleAuthor);
            articleDescription=itemView.findViewById(R.id.articleDescription);
        }
        public void onBind(final Articles articleModel){
            articleTitle.setText(articleModel.getTitle());
            articleAuthor.setText(articleModel.getAuthor());
            articleDescription.setText(articleModel.getDescription());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Enjoy reading", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(itemView.getContext(),SecondActivity.class);
                    intent.putExtra("hey",articleModel.getTitle());
                    intent.putExtra("nice",articleModel.getAuthor());
                    intent.putExtra("you",articleModel.getDescription());
                    intent.putExtra("we",articleModel.getPublishedAt());
                    intent.putExtra("us",articleModel.getUrl());
                    intent.putExtra("all",articleModel.getUrlToImage());
                    itemView.getContext().startActivity(intent);
                }
            });


        }
    }
}
