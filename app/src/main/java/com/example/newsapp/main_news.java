package com.example.newsapp;

import java.util.ArrayList;

public class main_news {
    private String status;
    private String totalResult;
    private ArrayList<model_class> articles;

    public main_news(String status, String totalResult, ArrayList<model_class> articles) {
        this.status = status;
        this.totalResult = totalResult;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(String totalResult) {
        this.totalResult = totalResult;
    }

    public ArrayList<model_class> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<model_class> articles) {
        this.articles = articles;
    }
}
