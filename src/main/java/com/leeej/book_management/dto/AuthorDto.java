package com.leeej.book_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDto {
    private Integer Id;

    @NotBlank(message = "이름을 입력하세요.")
    private String name;
}
