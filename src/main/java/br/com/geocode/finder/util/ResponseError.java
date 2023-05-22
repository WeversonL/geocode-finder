package br.com.geocode.finder.util;

import lombok.Getter;

@Getter
public enum ResponseError {

    TECHNICAL_EXCEPTION(500, "Technical Exception", "There were technical errors with the Google Maps API"),
    NOT_FOUND_EXCEPTION(404, "Not Found", "Unable to find the address provided");

    private final Integer statusCode;
    private final String description;
    private final String message;

    ResponseError(int statusCode, String description, String message) {
        this.statusCode = statusCode;
        this.description = description;
        this.message = message;
    }

}
