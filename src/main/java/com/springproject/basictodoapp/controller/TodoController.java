package com.springproject.basictodoapp.controller;

import com.springproject.basictodoapp.repository.TodoRepository;
import com.springproject.basictodoapp.service.TodoService;
import com.springproject.basictodoapp.todo.Todo;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;


@Controller
@SessionAttributes("userName")
public class TodoController {
    //private TodoService todoService;
    private TodoRepository repository;
    public TodoController( TodoRepository repository) {
        super();
        //this.todoService = todoService;
        this.repository = repository;
    }

    //get the logged-in user
    public String getLoggedUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping("list-todos")
    public String deleteTodo(ModelMap model){
        String userName = getLoggedUserName();
        List<Todo> todo = repository.findByUserName(userName);
        model.put("todo",todo);
        return "todo";
    };

    @RequestMapping(value="newTodo",method= RequestMethod.GET)
    public String showNewTodo(ModelMap model){
        String userName = (String)model.get("userName");
        Todo newTodo = new Todo(0,userName,"",LocalDate.now(),false);
        model.addAttribute("todo", newTodo);
        return "newTodo";
    };

    @RequestMapping(value="newTodo",method= RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "newTodo";
        }
        String userName = (String)model.get("userName");
        todo.setUserName(userName);
        //todoService.addAnewTodo(userName,todo.getDescription(),todo.getTarget(), false);
        repository.save(todo);
        return "redirect:list-todos";
    };

    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id){
        repository.deleteById(id);
        //todoService.deleteById(id);
        return "redirect:list-todos";
    };

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
        Todo todo = repository.findById(id).get();
        model.addAttribute("todo",todo);
        return "newTodo";
    };

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String saveUpdateTodoPage(Todo todo, ModelMap model){
//        Todo todo = todoService.findById(id);
//        todoService.updateTodo(todo,description,target);
        String userName = getLoggedUserName();
        todo.setUserName(userName);
        repository.save(todo);

        return "redirect:list-todos";
    };
}
