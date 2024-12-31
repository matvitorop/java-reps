package com.education.ztu.spring.service;

import com.education.ztu.spring.entity.TodoItem;
import com.education.ztu.spring.respository.TodoItemRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class TodoService {

    private final TodoItemRepository todoItemRepository;

    public TodoService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public List<TodoItem> getAllTodoItems() {
        Iterable<TodoItem> itemsIterator = todoItemRepository.findAll();
        return StreamSupport.stream(itemsIterator.spliterator(), false)
                .collect(Collectors.toList());
    }

    public TodoItem getTodoItemById(Long id) {
        return todoItemRepository.findByTodoId(id);
    }

    public void saveTodoItem(TodoItem todoItem) {
        todoItemRepository.save(todoItem);
    }

    public void updateTodoItem(TodoItem todoItem) {
        todoItemRepository.updateTodoItem(todoItem.getId(), todoItem.getData(), todoItem.getCompleted());
    }

    public void deleteTodoItem(Long id) {
        todoItemRepository.deleteTodoItemById(id);
    }
}
