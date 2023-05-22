package br.com.geocode.finder.exception.impl;

import br.com.geocode.finder.util.ResponseError;

import java.io.Serial;
import java.io.Serializable;

public class NotFoundException extends ApiException implements Serializable {

    @Serial
    private static final long serialVersionUID = -1836980466134086817L;

    public NotFoundException(ResponseError responseError) {
        super(responseError);
    }

}
