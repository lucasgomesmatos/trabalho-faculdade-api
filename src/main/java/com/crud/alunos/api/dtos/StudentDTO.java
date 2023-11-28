package com.crud.alunos.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {

    private String name;
    private String email;
    private UUID registration;
    private LocalDateTime createAt;
}
