package br.com.geocode.finder.exception.advice;

import br.com.geocode.finder.exception.impl.NotFoundException;
import br.com.geocode.finder.exception.impl.TechnicalException;
import br.com.geocode.finder.exception.model.ApiErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static br.com.geocode.finder.util.ResponseError.NOT_FOUND_EXCEPTION;
import static br.com.geocode.finder.util.ResponseError.TECHNICAL_EXCEPTION;

@ControllerAdvice
public class DefaultControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFoundException(NotFoundException e) {
        return ResponseEntity
                .status(NOT_FOUND_EXCEPTION.getStatusCode())
                .body(ApiErrorResponse.builder()
                        .code(NOT_FOUND_EXCEPTION.getStatusCode())
                        .description(NOT_FOUND_EXCEPTION.getDescription())
                        .message(NOT_FOUND_EXCEPTION.getMessage())
                        .build());
    }

    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<ApiErrorResponse> handleTechnicalException(TechnicalException e) {
        return ResponseEntity
                .status(TECHNICAL_EXCEPTION.getStatusCode())
                .body(ApiErrorResponse.builder()
                        .code(TECHNICAL_EXCEPTION.getStatusCode())
                        .description(TECHNICAL_EXCEPTION.getDescription())
                        .message(TECHNICAL_EXCEPTION.getMessage())
                        .build());
    }

}
