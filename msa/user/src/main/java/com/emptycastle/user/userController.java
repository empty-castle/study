package com.emptycastle.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class userController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/fetch")
    public String fetch(@RequestHeader Map<String, String> header) {
        logger.info("[USER] fetch");
        return "[USER] fetch";
    }
}
