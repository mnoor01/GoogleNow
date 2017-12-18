package com.example.c4q.hw12googlenow.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobbybah on 12/13/17.
 */

public class NYT_TopStories {
    String status;
    String copyright;
    String title;
    String last_updated;
    List<results> results = new ArrayList<>();

    public List<results> getResults(){
        return this.results;
    }

}
