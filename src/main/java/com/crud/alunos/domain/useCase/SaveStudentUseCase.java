package com.crud.alunos.domain.useCase;

import com.crud.alunos.api.dtos.StudentDTO;
import com.crud.alunos.api.dtos.ParamsSaveStudentDTO;
import com.crud.alunos.common.mapper.Mapper;
import com.crud.alunos.domain.models.Student;
import com.crud.alunos.domain.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SaveStudentUseCase {

    @Autowired
    private StudentService service;

    @Autowired
    private Mapper mapper;

    public StudentDTO saveStudent(ParamsSaveStudentDTO params) {

        var aluno = Student.builder()
                .name(params.getName())
                .email(params.getEmail())
                .build();

        return mapper.generalMapper(service.saveStudent(aluno), StudentDTO.class);
    }
}
