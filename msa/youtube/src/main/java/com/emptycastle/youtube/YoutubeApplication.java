package com.emptycastle.youtube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class YoutubeApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoutubeApplication.class, args);
    }

}
