package com.todoList.controller;

import com.todoList.data.TodoRepository;
import com.todoList.model.Todo;
import com.todoList.responseBody.AddTodoForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return todoRepository.addTodo(addTodoForm.getName());
    }
}
