package br.com.geocode.finder.controller;

import br.com.geocode.finder.model.Response;
import br.com.geocode.finder.service.GoogleMapsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class GeocodeControllerTest {
    @Mock
    private GoogleMapsService googleMapsService;

    private GeocodeController geocodeController;

    @Before
    public void setUp() {
        geocodeController = new GeocodeController(googleMapsService);
    }

    @Test
    public void testFindCoordinates_Success() {

        Response mockResponse = new Response();
        Mockito.when(googleMapsService.processAddressAndFindCoordinates(anyString())).thenReturn(mockResponse);

        ResponseEntity<Response> responseEntity = geocodeController.findCoordinates(anyString());

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockResponse, responseEntity.getBody());
    }

}
