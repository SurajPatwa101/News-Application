package com.example.newsapp;

public class model_class {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlTOImage;
    private String publishedAt;

    public model_class(String author, String title, String description, String url, String urlTOImage, String publishedAt) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlTOImage = urlTOImage;
        this.publishedAt = publishedAt;
    }
    //iska response tu konsi fileme lera h mtlb recycler kha h

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlTOImage() {
        return urlTOImage;
    }

    public void setUrlTOImage(String urlTOImage) {
        this.urlTOImage = urlTOImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
