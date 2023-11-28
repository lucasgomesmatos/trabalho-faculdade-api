package com.crud.alunos.domain.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExceptionBody {

    private HttpStatusCode status;
    private String error;
    private OffsetDateTime timestamp;
}
