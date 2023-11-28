package com.crud.alunos.domain.exception;

import com.crud.alunos.common.exception.ApiExceptionHandler;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentException {

    @ExceptionHandler(StudentCurrentException.class)
    protected ResponseEntity<Object> StudentCurrentException(StudentCurrentException exception) {
        return ApiExceptionHandler.handleGeneralException(exception, HttpStatusCode.valueOf(409));
    }


    @ExceptionHandler(StudentNotFoundException.class)
    protected ResponseEntity<Object> StudentNotFoundException(StudentNotFoundException exception) {
        return ApiExceptionHandler.handleGeneralException(exception, HttpStatusCode.valueOf(404));
    }
}
