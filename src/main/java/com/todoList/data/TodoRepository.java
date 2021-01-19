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

    public static Todo add(String name) {
        Todo todo = new Todo(name);
        todoList.add(0, todo);

        return todo;
    }

    public static boolean removeById(UUID taskId) {
        return todoList.removeIf(todo -> taskId.equals(todo.getId()));
    }

    public static boolean toggleIsCompletedById(UUID taskId) {
        int listSize = todoList.size() - 1;

        for (int i = listSize; i >= 0; i--) {
            Todo currentTodo = todoList.get(i);
            if (taskId.equals(currentTodo.getId())) {
                boolean newValue = !currentTodo.getIsCompleted();
                currentTodo.setIsCompleted(newValue);

                return newValue;
            }
        }

        return false;
    }
}
