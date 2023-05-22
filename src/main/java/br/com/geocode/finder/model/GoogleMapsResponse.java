package br.com.geocode.finder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoogleMapsResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -3531763651149210247L;

    private List<Results> results;

    private String status;

}
