package com.example.c4q.hw12googlenow.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.hw12googlenow.R;
import com.example.c4q.hw12googlenow.model.WeatherModel;
import com.example.c4q.hw12googlenow.views.NYT_ViewHolder;
import com.example.c4q.hw12googlenow.views.WeatherViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joannesong on 2/14/18.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {
    List<WeatherModel> weatherModelList = new ArrayList<>();

    public WeatherAdapter(List<WeatherModel> weatherModelList) {
        this.weatherModelList = weatherModelList;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_itemview, parent, false);

        return new WeatherViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {

        holder.onBind(weatherModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return weatherModelList.size();
    }
}
