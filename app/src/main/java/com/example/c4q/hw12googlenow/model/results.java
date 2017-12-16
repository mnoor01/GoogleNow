package com.example.c4q.hw12googlenow.model;

import android.support.annotation.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobbybah on 12/16/17.
 */

public class results {

        private String section;
        private String subsection;
        private String title;
        private String byline;
        private String url;
        private String published_date;
        List<multimedia> multimedia = new ArrayList<>();

        public List<multimedia> getMultimedia() {
            return this.multimedia;
        }

        public String getSection(){
            return section;
        }

        public String getSubsection(){
            return subsection;
        }
        public String getTitle(){
            return title;
        }

        public String getByline(){
            return byline;
        }

        public String getUrl(){
            return url;
        }

        public String getPublished_date(){
            return published_date;
        }
}
