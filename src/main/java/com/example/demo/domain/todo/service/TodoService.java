package com.example.demo.domain.todo.service;

import com.example.demo.domain.todo.entity.Todo;
import org.springframework.data.domain.Sort;

import java.util.List;


public interface TodoService {

    List<Todo> getTodos(Sort sort) throws Exception;

    void postTodo(Todo todo) throws Exception;

    void deleteTodo(Long id) throws Exception;

    Todo findTodoById(Long Id) throws Exception;
}