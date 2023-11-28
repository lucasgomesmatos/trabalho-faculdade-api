package com.crud.alunos.domain.repository;

import com.crud.alunos.domain.models.Student;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IStudentRepository extends CustomJpaRepository<Student, UUID> {

    Optional<Student> findByEmail(String email);
}
