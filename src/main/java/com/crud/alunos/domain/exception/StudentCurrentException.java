package com.crud.alunos.domain.exception;

public class StudentCurrentException extends RuntimeException{

    public StudentCurrentException(String mensagem) {
        super(mensagem);
    }
}
