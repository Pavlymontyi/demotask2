package com.example.demotask2.controller;

public enum Page {

    PERSONS("persons/all"),
    EXPENSES("/expense/all"),
    CATEGORIES("category/all");

    private String url;

    Page(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
