package com.emptycastle.streaming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class steamingController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/play")
    public Mono<String> play(@RequestBody Map<String, String> body) {
        return WebClient.create()
                .post()
                .uri("http://localhost:8081/fetch")
                .retrieve()
                .bodyToMono(String.class);
    }
}
