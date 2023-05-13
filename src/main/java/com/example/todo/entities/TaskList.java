package com.example.todo.entities;

import com.example.todo.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class TaskList {
    @Id
    @SequenceGenerator
            (
                    name="tasklist_sequence",
                    sequenceName = "tasklist_sequence",
                    allocationSize = 1
            )
    @GeneratedValue
            (
                    strategy = GenerationType.SEQUENCE,
                    generator = "tasklist_sequence"
            )
    Long id;

    String title;
    String comment;
    LocalDateTime created;
    LocalDateTime deadline;
    Enum status;

    @OneToMany
    public ArrayList<Task> tasks;

    public TaskList(String title, String comment) {
        this.title = title;
        this.comment = comment;
        this.created = LocalDateTime.now();
        this.status = TaskStatus.OPEN;
        this.tasks = new ArrayList<>();
    }

    public TaskList(String title, String comment, LocalDateTime deadline) {
        this.title = title;
        this.comment = comment;
        this.created = LocalDateTime.now();
        this.deadline = deadline;
        this.status = TaskStatus.OPEN;
    }

    public TaskList() {

    }

    public void addTask(Task task){
        this.tasks.add(task);
    }

    public void removeTask(Long id){
        this.tasks.remove(id);
    }

    public void changeTask(Long id, Task task){
        int index = id.intValue();
        this.tasks.add(index, task);
    }
}
