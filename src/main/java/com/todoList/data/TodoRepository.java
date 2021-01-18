package com.todoList.data;

import com.todoList.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TodoRepository {
    private static ArrayList<Todo> todoList = new ArrayList<Todo>(
            Arrays.asList(new Todo("Buy milk"), new Todo("Drink milk")
            ));

    public List<Todo> getAll() {
        return todoList;
    }

    public static Todo addTodo(String name) {
        Todo todo = new Todo(name);
        todoList.add(todo);

        return todo;
    }
}
