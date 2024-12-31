package com.education.ztu.spring.controller;


import com.education.ztu.spring.entity.TodoItem;
import com.education.ztu.spring.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TodoManagementController {

    private final TodoService todoService;

    public TodoManagementController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/edit/{id}")
    public String editTodoItem(@PathVariable Long id, Model model) {
        TodoItem todoItem = todoService.getTodoItemById(id);
        model.addAttribute("todo", todoItem);
        return "edit.html";
    }

    @PostMapping("/edit")
    public String updateTodoItem(@ModelAttribute TodoItem todoItem) {
        todoService.updateTodoItem(todoItem);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable Long id) {
        todoService.deleteTodoItem(id);
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "error.html";
    }
}
