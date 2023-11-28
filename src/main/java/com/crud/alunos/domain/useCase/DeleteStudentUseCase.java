package com.crud.alunos.domain.useCase;

import com.crud.alunos.domain.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteStudentUseCase {

    @Autowired
    private StudentService service;

    public void deleteStudent(UUID registration) {
        service.deleteStudent(registration);
    }
}
