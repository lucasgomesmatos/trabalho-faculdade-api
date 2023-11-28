package com.crud.alunos.api.controllers;

import com.crud.alunos.api.dtos.StudentDTO;
import com.crud.alunos.api.dtos.ParamsSaveStudentDTO;
import com.crud.alunos.domain.useCase.EditStudentUseCase;
import com.crud.alunos.domain.useCase.DeleteStudentUseCase;
import com.crud.alunos.domain.useCase.FindStudentUseCase;
import com.crud.alunos.domain.useCase.SaveStudentUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/students")
public class StudentController {


    @Autowired
    private FindStudentUseCase findStudentUseCase;

    @Autowired
    private SaveStudentUseCase saveStudentUseCase;

    @Autowired
    private EditStudentUseCase editStudentUseCase;

    @Autowired
    private DeleteStudentUseCase deleteStudentUseCase;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(findStudentUseCase.findStudents());
    }

    @GetMapping("{registration}")
    public ResponseEntity<StudentDTO> findStudent(@PathVariable UUID registration) {
        return ResponseEntity.status(HttpStatus.OK).body(findStudentUseCase.findStudent(registration));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody @Valid ParamsSaveStudentDTO params) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saveStudentUseCase.saveStudent(params));
    }

    @PutMapping("{registration}")
    public ResponseEntity<StudentDTO> editStudent(@PathVariable UUID registration, @RequestBody @Valid ParamsSaveStudentDTO params) {
        return ResponseEntity.status(HttpStatus.OK).body(editStudentUseCase.editStudent(registration, params));
    }

    @DeleteMapping("{registration}")
    public ResponseEntity<Void> deleteStudent(@PathVariable UUID registration) {

        deleteStudentUseCase.deleteStudent(registration);

        return ResponseEntity.noContent().build();
    }

}
