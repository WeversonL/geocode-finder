package br.com.geocode.finder.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ResponseErrorTest {

    @Test
    public void testTechnicalExceptionValues() {
        int expectedStatusCode = 500;
        String expectedDescription = "Technical Exception";
        String expectedMessage = "There were technical errors with the Google Maps API";

        ResponseError technicalException = ResponseError.TECHNICAL_EXCEPTION;

        assertEquals(expectedStatusCode, technicalException.getStatusCode().intValue());
        assertEquals(expectedDescription, technicalException.getDescription());
        assertEquals(expectedMessage, technicalException.getMessage());
    }

    @Test
    public void testNotFoundExceptionValues() {
        int expectedStatusCode = 404;
        String expectedDescription = "Not Found";
        String expectedMessage = "Unable to find the address provided";

        ResponseError notFoundException = ResponseError.NOT_FOUND_EXCEPTION;

        assertEquals(expectedStatusCode, notFoundException.getStatusCode().intValue());
        assertEquals(expectedDescription, notFoundException.getDescription());
        assertEquals(expectedMessage, notFoundException.getMessage());
    }
}
