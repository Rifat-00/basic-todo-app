package com.springproject.basictodoapp.service;

import com.springproject.basictodoapp.todo.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
     private static int todoCount = 0;

    static {
        todos.add(new Todo(++todoCount,"Abrar","Learn Spring Boot",LocalDate.now().plusMonths(3),false));
        todos.add(new Todo(++todoCount,"Abrar","Learn RDBMS",LocalDate.now().plusMonths(3), false));
        todos.add(new Todo(++todoCount,"Abrar","Learn React",LocalDate.now().plusMonths(3), false));
        todos.add(new Todo(++todoCount,"Abrar","Learn AWS", LocalDate.now().plusMonths(3), false));
    }

    public List<Todo> findByUserName(String name){
        Predicate<? super Todo> predicate = todo -> todo.getUserName().equals(name);
        return todos.stream().filter(predicate).toList();
    }

    public void addAnewTodo(String user,String description, LocalDate target, boolean done){

        Todo todo = new Todo(++todoCount,user,description,target,done);
        todos.add(todo);
    }

    public void updateTodo(Todo todo, String description, LocalDate target){

        todo.setDescription(description);
        todo.setTarget(target);
    }

    public void deleteById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
}
