package com.example.c4q.hw12googlenow.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c4q.hw12googlenow.R;
import com.example.c4q.hw12googlenow.model.WeatherModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by joannesong on 2/14/18.
 */

public class WeatherViewHolder extends RecyclerView.ViewHolder{
    private TextView timestamp;
    private TextView temperature;
    private TextView feelsLike;
    private TextView weatherSummary;
    private ImageView weatherIcon;

    public WeatherViewHolder(View itemView) {
        super(itemView);

        timestamp = itemView.findViewById(R.id.timeAndDateText);
        temperature = itemView.findViewById(R.id.tempText);
        feelsLike = itemView.findViewById(R.id.feelsLikeText);
        weatherSummary = itemView.findViewById(R.id.weatherSummaryText);
        weatherIcon = itemView.findViewById(R.id.weatherIcon);
    }

    public void onBind(WeatherModel weatherModel){
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);

        timestamp.setText(formattedDate);
        temperature.setText(weatherModel.getCurrently().getTemperature() + "");
        feelsLike.setText("Feels like "
                + weatherModel.getCurrently().getApparentTemperature());
        weatherSummary.setText(weatherModel.getCurrently().getSummary());

    }
}
























