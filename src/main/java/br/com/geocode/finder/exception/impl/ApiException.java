package br.com.geocode.finder.exception.impl;

import br.com.geocode.finder.exception.model.ApiErrorResponse;
import br.com.geocode.finder.util.ResponseError;

import java.io.Serial;
import java.io.Serializable;

public class ApiException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = -4143397863270712990L;

    public ApiException(ResponseError responseError) {
        ApiErrorResponse.builder()
                .code(responseError.getStatusCode())
                .description(responseError.getDescription())
                .message(responseError.getMessage())
                .build();
    }

}
