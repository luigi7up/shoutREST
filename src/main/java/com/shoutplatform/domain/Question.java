/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoutplatform.domain;

/**
 * Represents a question that someone asked. A question can belong to many groups and have many
 * answers and comments
 * @author luka
 */
public class Question {
    private int id;
    private String title;
    private boolean resolved;

    public Question() {
    }

    public Question(int id, String title, boolean resolved) {
        this.id = id;
        this.title = title;
        this.resolved = resolved;
    }

    
    //SET /GET
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
    
    
    
}
