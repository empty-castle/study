package com.emptycastle.streaming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class SteamingController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WebClient webClient;

    @PostMapping("/play")
    public Mono<String> play(@RequestBody Map<String, String> body) {
        return webClient
                .mutate()
                .filter((request, next) -> next.exchange(
                        ClientRequest.from(request).header("test", "test").build()
                ))
                .build()
                .post()
                .uri("http://localhost:80/fetch")
//                .uri("http://localhost:8081/fetch")
                .retrieve()
                .bodyToMono(String.class);
    }
}
