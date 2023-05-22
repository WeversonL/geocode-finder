package br.com.geocode.finder.exception.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1278426307994317284L;

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("description")
    private String description;

    @JsonProperty("message")
    private String message;

}
