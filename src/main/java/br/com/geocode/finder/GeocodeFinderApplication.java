package br.com.geocode.finder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GeocodeFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeocodeFinderApplication.class, args);
    }

}
