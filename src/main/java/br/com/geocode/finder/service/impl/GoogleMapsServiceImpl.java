package br.com.geocode.finder.service.impl;

import br.com.geocode.finder.adapter.Parser;
import br.com.geocode.finder.client.GoogleMapsClient;
import br.com.geocode.finder.exception.impl.NotFoundException;
import br.com.geocode.finder.exception.impl.TechnicalException;
import br.com.geocode.finder.model.GoogleMapsResponse;
import br.com.geocode.finder.model.Response;
import br.com.geocode.finder.service.GoogleMapsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static br.com.geocode.finder.util.ResponseError.NOT_FOUND_EXCEPTION;
import static br.com.geocode.finder.util.ResponseError.TECHNICAL_EXCEPTION;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoogleMapsServiceImpl implements GoogleMapsService {

    private final static String RESPONSE_NOT_FOUND = "ZERO_RESULTS";

    private final GoogleMapsClient googleMapsClient;

    @Override
    public Response processAddressAndFindCoordinates(String address) {

        try {

            log.info("Starting coordinate search...");

            String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8);

            GoogleMapsResponse coordinates = googleMapsClient.getCoordinates(encodedAddress);

            if (coordinates.getResults().isEmpty() || coordinates.getStatus().equals(RESPONSE_NOT_FOUND)) {
                throw new NotFoundException(NOT_FOUND_EXCEPTION);
            }

            Response response = Parser.parseToResponse(coordinates);

            log.info("Sucess request. Response -> {}", response);

            return response;

        } catch (NotFoundException e) {
            log.error("Not found address -> ", e);
            throw e;
        } catch (Exception e) {
            log.error("Error running the service -> ", e);
            throw new TechnicalException(TECHNICAL_EXCEPTION);
        }

    }

}
