package com.timwetech.entrevista.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiError {
    private int status;
    private String titulo;
    private String mensagem;
    private LocalDateTime timestamp;
}

