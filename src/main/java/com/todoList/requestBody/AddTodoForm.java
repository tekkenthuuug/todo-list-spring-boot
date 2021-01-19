package com.todoList.requestBody;

public class AddTodoForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddTodoForm() {
    }
    public AddTodoForm(String name) {
        this.name = name;
    }
}
