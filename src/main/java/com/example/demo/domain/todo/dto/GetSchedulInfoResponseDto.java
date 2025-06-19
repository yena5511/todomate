package com.example.demo.domain.todo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetSchedulInfoResponseDto {

    private long id;
    private String title;
}
