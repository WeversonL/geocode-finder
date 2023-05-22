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
public class Location implements Serializable {

    @Serial
    private static final long serialVersionUID = -1310536752823041411L;

    private Double lat;
    private Double lng;

}
