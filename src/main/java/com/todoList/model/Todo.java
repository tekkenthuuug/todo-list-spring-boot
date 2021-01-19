package com.todoList.model;

import java.util.Date;
import java.util.UUID;

public class Todo {
    private String name;
    private Boolean isCompleted = false;
    private Date createdDate = new Date();
    private UUID id = UUID.randomUUID();

    public Todo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UUID getId() {
        return id;
    }
}
