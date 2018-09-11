package com.students.controller;

import com.students.application.UserApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserConnectController extends BaseController {

    @Autowired
    UserApplicationServices userApplicationServices;

    @RequestMapping(value = "/user/{email}/" , method = RequestMethod.GET)
    public UserDTO login(@PathVariable String email) {
        return userApplicationServices.login(email);
    }

}

