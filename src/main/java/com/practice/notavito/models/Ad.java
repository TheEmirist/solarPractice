package com.practice.notavito.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, short_text, full_text;
    private int cost;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
    
    public Ad() {
    }
    public Ad(String title, String short_text, String full_text, int cost, User user) {
        this.title = title;
        this.short_text = short_text;
        this.full_text = full_text;
        this.cost = cost;
        this.author = user;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getShort_text() {
        return short_text;
    }
    public void setShort_text(String short_text) {
        this.short_text = short_text;
    }
    public String getFull_text() {
        return full_text;
    }
    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }
    
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }
}
