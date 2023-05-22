package br.com.geocode.finder.model;

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
public class Response implements Serializable {

    @Serial
    private static final long serialVersionUID = 539940188253335285L;

    private String address;
    private Double latitude;
    private Double longitude;

}
