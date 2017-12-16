package com.example.c4q.hw12googlenow.model;

/**
 * Created by c4q on 12/16/17.
 */

public class BBCmodel {
    private String status;
    private long totalResults;
    private Articles[] articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }

    public Articles[] getArticles() {
        return articles;
    }

    public void setArticles(Articles[] articles) {
        this.articles = articles;
    }
}
