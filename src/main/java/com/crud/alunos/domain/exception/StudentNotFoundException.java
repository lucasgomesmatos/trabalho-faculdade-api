package com.crud.alunos.domain.exception;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String mensagem) {
        super(mensagem);
    }
}
