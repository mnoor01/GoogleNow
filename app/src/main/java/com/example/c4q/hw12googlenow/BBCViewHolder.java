package com.example.c4q.hw12googlenow;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by c4q on 12/12/17.
 */

public class GoogleViewHolder extends RecyclerView.ViewHolder {
    private TextView articleList;
    public GoogleViewHolder(View itemView) {
        super(itemView);
        articleList= (TextView) itemView.findViewById(R.id.listofarticles);

    }

    public void BindingArticlesIGuess(GoogleModel instantiatedModel){

        instantiatedModel.setArticle(articleList.toString());
    }
}
