package br.com.geocode.finder.client;

import br.com.geocode.finder.model.GoogleMapsResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GoogleMapsClientTest {

    @Mock
    private GoogleMapsClient googleMapsClient;

    @Test
    public void testGetCoordinates() {

        String address = "123 Main St";
        GoogleMapsResponse mockResponse = new GoogleMapsResponse();
        Mockito.when(googleMapsClient.getCoordinates(address)).thenReturn(mockResponse);

        GoogleMapsResponse response = googleMapsClient.getCoordinates(address);

        Assert.assertNotNull(response);

    }
}
