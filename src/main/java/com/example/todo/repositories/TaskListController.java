package com.example.todo.repositories;

import com.example.todo.entities.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author MagnoTheFirst
 * @version 14.05.2023
 * */
@Repository
@EnableJpaRepositories
public interface TaskListController extends JpaRepository<TaskList, Long> {

    @Query("SELECT tl FROM TaskList tl WHERE tl.title = ?1")
    Optional<TaskList> findByName(String title);

}
