package com.shoutplatform.domain.objects;

import java.util.List;

public class Category {

    private Integer id;
    private String name;
    private List<Question> questions;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    
    @Override
    public String toString(){
        return "Category: "+this.name;
    }
    
}