package com.example.todo.interfaces;

import com.example.todo.entities.Task;

import java.util.List;

public interface TaskService {

    public List<Task> getTaskList();

    public void addTask(Task task);


}
