package com.todoList.controller;

import com.todoList.data.TodoRepository;
import com.todoList.model.Todo;
import com.todoList.requestBody.AddTodoForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class TodoListController {

    private TodoRepository todoRepository = new TodoRepository();

    @RequestMapping(value = "/")
    public String indexPage(ModelMap modelMap) {
        modelMap.put("todoList", todoRepository.getAll());

        return "index";
    }

    @PostMapping(value = "/api/task/create")
    @ResponseBody
    public Todo addTodo(@RequestBody AddTodoForm addTodoForm) {
        return todoRepository.add(addTodoForm.getName());
    }

    @DeleteMapping(value = "/api/task/{taskId}")
    @ResponseBody
    public boolean removeTodo(@PathVariable String taskId) {
        UUID uuid = UUID.fromString(taskId);

        return todoRepository.removeById(uuid);
    }

    @PutMapping(value = "/api/task/complete/{taskId}")
    @ResponseBody
    public boolean completeTodo(@PathVariable String taskId) {
        UUID uuid = UUID.fromString(taskId);

        return todoRepository.toggleIsCompletedById(uuid);
    }
}
