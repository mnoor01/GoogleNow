package com.example.c4q.hw12googlenow.views;

import android.nfc.Tag;
import android.speech.tts.TextToSpeech;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.c4q.hw12googlenow.R;
import com.example.c4q.hw12googlenow.model.NYT_TopStories;


/**
 * Created by bobbybah on 12/18/17.
 */

public class NYT_ViewHolder extends RecyclerView.ViewHolder {

    private final static String TAG = "HELP!!!!";
    private ImageView article_Image;
    private TextView article_Title;
    private TextView article_Byline;


    public NYT_ViewHolder(View itemView) {
        super(itemView);

    article_Image = itemView.findViewById(R.id.article_image);
    article_Title = itemView.findViewById(R.id.title_view);
    article_Byline = itemView.findViewById(R.id.byline_view);
    }

    public void onBind(NYT_TopStories results) {

        article_Title.setText(results.getResults().get(0).getTitle());
        article_Byline.setText(results.getResults().get(0).getByline());

        String imgURL = results.getResults().get(0).getMultimedia().get(0).getUrl();
        Glide.with(article_Image.getContext())
                .load(imgURL)
                //try to resize the image to make more visible
                .into(article_Image);

        Log.d(TAG, String.valueOf(article_Title));
    }
}
