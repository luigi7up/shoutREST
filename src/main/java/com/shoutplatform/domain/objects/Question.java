package com.shoutplatform.domain.objects;

import java.util.List;

public class Question {
   
    private Integer id;
    private String title;
    private String text;
    private List<Category> categories;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
    
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }
    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    @Override
    public String toString(){
        return "Question: "+this.title;
    }
}