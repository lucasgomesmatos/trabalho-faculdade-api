package com.crud.alunos.domain.useCase;

import com.crud.alunos.api.dtos.StudentDTO;
import com.crud.alunos.common.mapper.Mapper;
import com.crud.alunos.domain.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class FindStudentUseCase {

    @Autowired
    private StudentService service;

    @Autowired
    private Mapper mapper;

    public List<StudentDTO> findStudents() {
        return mapper.mapCollection(service.findStudents(), StudentDTO.class);
    }

    public StudentDTO findStudent(UUID registration) {
        return mapper.generalMapper(service.findStudent(registration), StudentDTO.class);
    }
}
