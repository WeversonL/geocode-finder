package br.com.geocode.finder.adapter;

import br.com.geocode.finder.model.GoogleMapsResponse;
import br.com.geocode.finder.model.Location;
import br.com.geocode.finder.model.Response;

public class Parser {

    private Parser() {

    }

    public static Response parseToResponse(GoogleMapsResponse googleMapsResponse) {

        String formattedAddress = googleMapsResponse.getResults().get(0).getFormattedAddress();
        Location location = googleMapsResponse.getResults().get(0).getGeometry().getLocation();

        return Response.builder()
                .address(formattedAddress)
                .latitude(location.getLat())
                .longitude(location.getLng())
                .build();

    }

}
