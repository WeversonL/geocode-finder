package br.com.geocode.finder.controller;

import br.com.geocode.finder.model.Response;
import br.com.geocode.finder.service.GoogleMapsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GeocodeController {

    private final GoogleMapsService googleMapsService;

    @GetMapping("/geocode")
    public ResponseEntity<Response> findCoordinates(@RequestParam("address") String address) {

        Response response = googleMapsService.processAddressAndFindCoordinates(address);

        return ResponseEntity.ok(response);

    }

}
