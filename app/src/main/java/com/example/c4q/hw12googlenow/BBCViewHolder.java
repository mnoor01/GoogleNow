package com.example.c4q.hw12googlenow;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by c4q on 12/12/17.
 */

public class BBCViewHolder extends RecyclerView.ViewHolder {
    private TextView articleList;
    private View articlesItemView;
    BBCSport model;
    public BBCViewHolder(View itemView) {
        super(itemView);
        articleList= (TextView) itemView.findViewById(R.id.listofarticles);


    }

    public void BindingArticlesIGuess( BBCSport instantiatedModel){
        model = instantiatedModel;
//        String message=articleList.getText().toString();

//        instantiatedModel.setArticle(message);
        articleList.setText(instantiatedModel.getArticle());
        articlesItemView= (View) itemView.findViewById(R.id.itemviewariticles);

        articleList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(itemView.getContext(), "", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(itemView.getContext(),SecondActivity.class);
                intent.putExtra("hey",model.getArticle());
                itemView.getContext().startActivity(intent);

            }
        });

    }
}
