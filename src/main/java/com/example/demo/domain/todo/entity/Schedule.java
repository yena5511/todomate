package com.example.demo.domain.todo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Schedule implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String document_date;

    @Column
    private String document_passed;

    @Column
    private String written_date;

    @Column
    private String written_passed;

    @Column
    private String interview;

    @Column
    private String result;

    public void updateSchedule(String title, String document_date, String document_passed, String written_date,
                               String written_passed, String interview, String result) {
        this.title = title;
        this.document_date = document_date;
        this.document_passed = document_passed;
        this.written_date = written_date;
        this.written_passed = written_passed;
        this.interview = interview;
        this.result = result;
    }
}

