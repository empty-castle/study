package com.inflearn.restfulwebservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// HTTP Status codd
// 2xx -> OK
// 4xx -> Client
// 5xx -> Server
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
