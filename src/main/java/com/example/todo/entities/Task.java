package com.example.todo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Task {

    @Id
    @SequenceGenerator
            (
                    name="task_sequence",
                    sequenceName = "task_sequence",
                    allocationSize = 1
            )
    @GeneratedValue
            (
                    strategy = GenerationType.SEQUENCE,
                    generator = "stock_sequence"
            )
    Long taskId;
    String title;
    String comment;
    LocalDateTime created;
    LocalDateTime deadline;
    Enum status;


}
