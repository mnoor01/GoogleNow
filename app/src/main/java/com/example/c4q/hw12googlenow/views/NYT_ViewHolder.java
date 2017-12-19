package com.example.c4q.hw12googlenow.views;

import android.nfc.Tag;
import android.speech.tts.TextToSpeech;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c4q.hw12googlenow.R;
import com.example.c4q.hw12googlenow.model.NYT_TopStories;


/**
 * Created by bobbybah on 12/18/17.
 */

public class NYT_ViewHolder extends RecyclerView.ViewHolder {

    private final static String TAG = "HELP!!!!";
    private ImageView article_Image;
    private TextView article_Title;
    private TextView article_Abstract;
    private TextView article_Byline;
    private TextView article_Publised_Date;

    public NYT_ViewHolder(View itemView) {
        super(itemView);

    article_Image = itemView.findViewById(R.id.article_image);
    article_Title = itemView.findViewById(R.id.title_view);
    article_Abstract = itemView.findViewById(R.id.abstract_view);
    article_Byline = itemView.findViewById(R.id.byline_view);
    article_Publised_Date = itemView.findViewById(R.id.published_date_view);
    }

    public void onBind(NYT_TopStories.Results results) {
        article_Title.setText(results.getTitle());
        Log.d(TAG, String.valueOf(article_Title));
    }
}
