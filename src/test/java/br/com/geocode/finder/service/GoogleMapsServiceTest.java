package br.com.geocode.finder.service;

import br.com.geocode.finder.client.GoogleMapsClient;
import br.com.geocode.finder.exception.impl.NotFoundException;
import br.com.geocode.finder.exception.impl.TechnicalException;
import br.com.geocode.finder.model.*;
import br.com.geocode.finder.service.impl.GoogleMapsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class GoogleMapsServiceTest {
    @Mock
    private GoogleMapsClient googleMapsClient;

    private GoogleMapsServiceImpl googleMapsService;

    @Before
    public void setUp() {
        googleMapsService = new GoogleMapsServiceImpl(googleMapsClient);
    }

    @Test
    public void testProcessAddressAndFindCoordinates_Success() {

        Results results = Results.builder()
                .formattedAddress("a")
                .geometry(Geometry.builder()
                        .location(Location.builder()
                                .lat(-50.0)
                                .lng(-50.0)
                                .build())
                        .build())
                .build();

        GoogleMapsResponse mockResponse = GoogleMapsResponse.builder()
                .status("SUCESS")
                .results(List.of(results))
                .build();

        Mockito.when(googleMapsClient.getCoordinates(anyString())).thenReturn(mockResponse);

        Response response = googleMapsService.processAddressAndFindCoordinates(anyString());

        Assert.assertNotNull(response);

    }

    @Test(expected = NotFoundException.class)
    public void testProcessAddressAndFindCoordinates_NotFound() {

        GoogleMapsResponse mockResponse = GoogleMapsResponse.builder()
                .results(new ArrayList<>())
                .status("ZERO_RESULTS")
                .build();

        Mockito.when(googleMapsClient.getCoordinates(anyString())).thenReturn(mockResponse);

        googleMapsService.processAddressAndFindCoordinates(anyString());

    }

    @Test(expected = TechnicalException.class)
    public void testProcessAddressAndFindCoordinates_TechnicalException() {

        Mockito.when(googleMapsClient.getCoordinates(anyString())).thenThrow(new RuntimeException("Something went wrong"));

        googleMapsService.processAddressAndFindCoordinates(anyString());
    }

}
