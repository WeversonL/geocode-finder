package br.com.geocode.finder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Results implements Serializable {

    @Serial
    private static final long serialVersionUID = -4895076489514605991L;

    @JsonProperty("formatted_address")
    private String formattedAddress;

    private Geometry geometry;

}
