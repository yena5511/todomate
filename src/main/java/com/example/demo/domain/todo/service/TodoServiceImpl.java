package com.example.demo.domain.todo.service;


import com.example.demo.domain.todo.entity.Todo;
import com.example.demo.domain.todo.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getTodos(Sort sort) throws Exception {
        return todoRepository.findAll(sort);
    }

    @Override
    @Transactional // 꼭 필요
    public void postTodo(Todo todo) throws Exception {
        System.out.println(">>> 저장 전 todo: " + todo);
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long id) throws Exception {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo findTodoById(Long id) throws Exception {
        return todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 Todo가 존재하지 않습니다: " + id));
    }
}
