package com.crud.alunos.domain.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.OffsetDateTime;


@Data
@Builder
@AllArgsConstructor
public class ErrorExceptionMessage {

    private  String campo;
    private String mensagem;
    private OffsetDateTime timestamp;

}
