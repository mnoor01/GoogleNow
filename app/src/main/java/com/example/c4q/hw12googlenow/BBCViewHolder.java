package com.example.c4q.hw12googlenow;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by c4q on 12/12/17.
 */

public class BBCViewHolder extends RecyclerView.ViewHolder {
    private TextView articleList;
    public BBCViewHolder(View itemView) {
        super(itemView);
        articleList= (TextView) itemView.findViewById(R.id.listofarticles);

    }

    public void BindingArticlesIGuess(BBCSport instantiatedModel){
//        String message=articleList.getText().toString();

//        instantiatedModel.setArticle(message);
        articleList.setText(instantiatedModel.getArticle());
    }
}
