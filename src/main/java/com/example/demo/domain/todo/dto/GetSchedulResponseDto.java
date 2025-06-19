package com.example.demo.domain.todo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetSchedulResponseDto {

    private String title;

    private String document_date;

    private String document_passed;

    private String written_date;

    private String written_passed;

    private String interview;

    private String result;
}
