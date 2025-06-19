package com.example.demo.domain.todo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CreateSchedulRequestDto {

    @NotNull
    private String title;

    @NotNull
    private String document_date;

    @NotNull
    private String document_passed;

    @NotNull
    private String written_date;

    @NotNull
    private String written_passed;

    @NotNull
    private String interview;

    @NotNull
    private String result;


}
