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
public class Geometry implements Serializable {

    @Serial
    private static final long serialVersionUID = 2219856209594808484L;

    private Location location;

}
