package com.appsdeveloperblog.app.ws.ui.controller;

import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    @GetMapping()
    public String getUsers(@RequestParam(value="page", defaultValue = "1") int page,
                           @RequestParam(value="limit", defaultValue = "50") int limit,
                           @RequestParam(value="sort", defaultValue = "desc", required = false) String sort) {

        return "get users was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
    }

    @GetMapping(path="/{userId}", produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public UserRest getUser(@PathVariable String userId) {

        UserRest returnValue = new UserRest();
        returnValue.setEmail("test@test.com");
        returnValue.setFristName("kento");
        returnValue.setLastName("takano");

        return returnValue;
    }

    @PostMapping
    public String createUser() {

        return "create user was called";
    }

    @PutMapping
    public String updateUser() {

        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {

        return "delete user was called";
    }
}
