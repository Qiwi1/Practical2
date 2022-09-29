package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Post {
    public Post(String modelsTel, String number, String memory, String memoryGB, String operator) {
        this.modelsTel = modelsTel;
        this.number = number;
        this.memory = memory;
        this.memoryGB = memoryGB;
        this.operator = operator;

    }

    public Post() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String modelsTel,  number,  memory,  memoryGB,  operator;
    private int views;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelsTel() {
        return modelsTel;
    }

    public void setModelsTel(String modelsTel) {
        this.modelsTel = modelsTel;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMemoryGB() {
        return memoryGB;
    }

    public void setMemoryGB(String memoryGB) {
        this.memoryGB = memoryGB;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
