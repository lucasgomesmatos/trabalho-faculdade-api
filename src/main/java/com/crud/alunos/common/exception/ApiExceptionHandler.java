package com.crud.alunos.common.exception;

import com.crud.alunos.domain.exception.ErrorExceptionMessage;
import com.crud.alunos.domain.exception.ExceptionBody;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler {

    private MessageSource messageSource;

    public ApiExceptionHandler(MessageSource message) {
        this.messageSource = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorExceptionMessage>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ErrorExceptionMessage> erros = new ArrayList<>();


        exception.getBindingResult().getFieldErrors().forEach((err) -> {
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());

            var error = ErrorExceptionMessage.builder()
                    .campo(err.getField())
                    .mensagem(message)
                    .timestamp(OffsetDateTime.now())
                    .build();
            erros.add(error);
        });

        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }


    public static ResponseEntity<Object> handleGeneralException(Exception exception, HttpStatusCode status) {

        var body = ExceptionBody.builder()
                .error(exception.getMessage())
                .status(status)
                .timestamp(OffsetDateTime.now())
                .build();

        return new ResponseEntity<>(body, status);
    }
}
