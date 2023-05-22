package br.com.geocode.finder.service;

import br.com.geocode.finder.model.Response;

public interface GoogleMapsService {

    Response processAddressAndFindCoordinates(String address);

}
