package com.example.todo.repositories;

import com.example.todo.entities.Task;
import com.example.todo.entities.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {


    @Query("SELECT task FROM Task task WHERE task.title = ?1")
    Optional<TaskList> findByName(String title);

}
