package br.com.geocode.finder.client;

import br.com.geocode.finder.model.GoogleMapsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "GoogleMapsClient", url = "${app.google-url}/json?key=${app.google-api-key}")
public interface GoogleMapsClient {

    @GetMapping
    GoogleMapsResponse getCoordinates(
            @RequestParam("address") String address);

}
