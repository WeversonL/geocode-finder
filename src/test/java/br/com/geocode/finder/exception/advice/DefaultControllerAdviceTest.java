package br.com.geocode.finder.exception.advice;

import br.com.geocode.finder.exception.impl.NotFoundException;
import br.com.geocode.finder.exception.impl.TechnicalException;
import br.com.geocode.finder.exception.model.ApiErrorResponse;
import br.com.geocode.finder.util.ResponseError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DefaultControllerAdviceTest {

    @InjectMocks
    private DefaultControllerAdvice defaultControllerAdvice;

    @Test
    public void testHandleNotFoundException() {

        NotFoundException exception = new NotFoundException(ResponseError.NOT_FOUND_EXCEPTION);
        ResponseEntity<ApiErrorResponse> responseEntity = defaultControllerAdvice.handleNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

    }

    @Test
    public void testHandleTechnicalException() {

        TechnicalException exception = new TechnicalException(ResponseError.TECHNICAL_EXCEPTION);
        ResponseEntity<ApiErrorResponse> responseEntity = defaultControllerAdvice.handleTechnicalException(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());

    }
}