package com.example.backend.config;

import com.example.backend.service.PlanetClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.Duration;

@Configuration
public class SwapiClientConfig {

    public static final String SWAPI= "https://swapi.dev/api";

    @Bean
    PlanetClient planetClient() {
        WebClient client = WebClient.builder()
                .baseUrl(SWAPI)
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client))
                .blockTimeout(Duration.ofSeconds(30))
                .build();
        return factory.createClient(PlanetClient.class);
    }
}
