package com.example.demo.domain.todo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Todo implements Serializable {

    private static final long serialVersionUID = -947585423656694361L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private LocalDateTime createdDateTime;

    @Column(name = "is_complete")
    private Boolean isComplete;

    @Builder
    public Todo(Long id, String content, LocalDateTime createdDateTime, Boolean isComplete) {
        this.id = id;
        this.content = content;
        this.createdDateTime = createdDateTime;
        this.isComplete = isComplete;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id +
                ", content=" + content +
                ", createdDateTime=" + createdDateTime +
                ", isComplete=" + isComplete + "]";
    }
}