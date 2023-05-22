package br.com.geocode.finder.exception.impl;

import br.com.geocode.finder.util.ResponseError;

import java.io.Serial;
import java.io.Serializable;

public class TechnicalException extends ApiException implements Serializable {

    @Serial
    private static final long serialVersionUID = 7355592667231762852L;

    public TechnicalException(ResponseError responseError) {
        super(responseError);
    }

}
