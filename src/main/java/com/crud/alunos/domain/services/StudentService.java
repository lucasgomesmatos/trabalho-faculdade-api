package com.crud.alunos.domain.services;

import com.crud.alunos.domain.exception.StudentCurrentException;
import com.crud.alunos.domain.exception.StudentNotFoundException;
import com.crud.alunos.domain.models.Student;
import com.crud.alunos.domain.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static com.crud.alunos.common.message.MessageException.MESSAGE_STUDENT_CURRENT_EXCEPTION;
import static com.crud.alunos.common.message.MessageException.MESSAGE_STUDENT_NOT_FOUND_EXCEPTION;

@Service
public class StudentService {

    @Autowired
    private IStudentRepository repository;


    public List<Student> findStudents() {
        return repository.findAll();
    }

    public Student findStudent(UUID registration) {
        return repository.findById(registration).orElseThrow(() -> new StudentNotFoundException(MESSAGE_STUDENT_NOT_FOUND_EXCEPTION));
    }

    @Transactional
    public Student saveStudent(Student student) {
        repository.detach(student);

        var studentCurrent = repository.findByEmail(student.getEmail());

        if (studentCurrent.isPresent() && !studentCurrent.get().equals(student)) {
            throw new StudentCurrentException(MESSAGE_STUDENT_CURRENT_EXCEPTION);
        }

        return repository.save(student);
    }

    public void deleteStudent(UUID registration) {
        var student = findStudent(registration);
        repository.delete(student);
    }
}
