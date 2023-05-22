package br.com.geocode.finder.adapter;

import br.com.geocode.finder.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ParserTest {

    @Test
    public void testParseToResponse() {

        String formattedAddress = "123 Main St";
        double latitude = 37.123456;
        double longitude = -122.654321;

        Results result = new Results();
        result.setFormattedAddress(formattedAddress);
        Geometry geometry = new Geometry();
        Location location = new Location();
        location.setLat(latitude);
        location.setLng(longitude);
        geometry.setLocation(location);
        result.setGeometry(geometry);

        GoogleMapsResponse googleMapsResponse = new GoogleMapsResponse();
        googleMapsResponse.setResults(Collections.singletonList(result));

        Response expectedResponse = Response.builder()
                .address(formattedAddress)
                .latitude(latitude)
                .longitude(longitude)
                .build();

        Response response = Parser.parseToResponse(googleMapsResponse);

        assertEquals(expectedResponse, response);

    }

}
