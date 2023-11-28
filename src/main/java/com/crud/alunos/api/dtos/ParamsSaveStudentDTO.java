package com.crud.alunos.api.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParamsSaveStudentDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

}
