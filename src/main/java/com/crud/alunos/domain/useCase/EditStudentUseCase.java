package com.crud.alunos.domain.useCase;

import com.crud.alunos.api.dtos.StudentDTO;
import com.crud.alunos.api.dtos.ParamsSaveStudentDTO;
import com.crud.alunos.common.mapper.Mapper;
import com.crud.alunos.domain.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class EditStudentUseCase {

    @Autowired
    private StudentService service;

    @Autowired
    private Mapper mapper;

    public StudentDTO editStudent(UUID registration, ParamsSaveStudentDTO params) {

        var studentCurrent = service.findStudent(registration);

        studentCurrent.setEmail(params.getEmail());
        studentCurrent.setName(params.getName());
        studentCurrent.setUpdateAt(LocalDateTime.now());

        return mapper.generalMapper(service.saveStudent(studentCurrent), StudentDTO.class);
    }
}
