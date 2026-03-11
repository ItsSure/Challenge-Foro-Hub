package com.foro.hub.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.foro.hub.Utils.TopicNotFoundException;
import com.foro.hub.dtos.ErrorResponseDto;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDto handleValidFiel(MethodArgumentNotValidException ex) {
        List<String> e = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .toList();

        return new ErrorResponseDto(
                HttpStatus.NOT_FOUND.name(),
                ex.getMessage(),
                LocalDateTime.now(),
                List.of("El recurso solicitado no existe"));
    }

    @ExceptionHandler(TopicNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDto handleNotFound(TopicNotFoundException ex) {
        return new ErrorResponseDto(
                HttpStatus.NOT_FOUND.name(),
                ex.getMessage(),
                LocalDateTime.now(),
                List.of("El recurso solicitado no existe"));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDto handleInternalError(Exception ex) {
        return new ErrorResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                "Error interno del servidor",
                LocalDateTime.now(),
                List.of(ex.getClass().getSimpleName()));
    }
}
