package com.emptycastle.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class userController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/fetch")
    public String fetch() {
        logger.info("[USER] fetch");
        return "[USER] fetch";
    }
}
