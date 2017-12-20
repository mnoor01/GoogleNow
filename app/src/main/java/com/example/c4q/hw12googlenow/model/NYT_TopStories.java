package com.example.c4q.hw12googlenow.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobbybah on 12/13/17.
 */

public class NYT_TopStories {
    String status;
    String copyright;
    String section;
    String last_updated;
    int num_results;
    List<Results> results;

    public String getStatus() {
        return this.status;
    }

    public List<Results> getResults() {
        return this.results;
    }

    public class Results {
        String section;
        String subsection;
        String title;
//        String abstract;
        String url;
        String byline;
        String item_type;
        String updated_type;
        String created_date;
        String published_date;
        String material_type_facet;
        String kicker;
        List<String> des_facet = new ArrayList<>();
        List<String> org_facet = new ArrayList<>();
        List<String> per_facet = new ArrayList<>();
        List<String> geo_facet = new ArrayList<>();
        List<multimedia> multimedia = new ArrayList<>();
        String short_url;

        public String getTitle() {
            return this.title;
        }

        public String getByline() {
            return this.byline;
        }

        public List<multimedia> getMultimedia() {
            return multimedia;
        }

        public String getUrl() {
            return this.url;
        }

        public class des_facet {
        }

        public class org_facet {
        }

        public class per_facet {
        }

        public class geo_facet {
        }

        public class multimedia {
            String url;
            String format;
            int height;
            int width;
            String type;
            String subtype;
            String caption;
            String copyright;

            public String getUrl() {
                return this.url;
            }
        }
    }

}

