package com.springproject.basictodoapp.todo;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Integer id;
    private String userName;
    @Size(min = 10,message = "Enter at least 10 character")
    private String description;

    private LocalDate target;
    private boolean done;

    public Todo(int id, String userName, String description,LocalDate target, boolean done) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.target = target;
        this.done = done;
    }

    public Todo() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTarget() {
        return target;
    }

    public void setTarget(LocalDate target) {
         this.target = target;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
//                ", CompletionTarget=" + target +
                ", done=" + done +
                '}';
    }
}
