package com.uncub.controller;

import org.springframework.web.bind.annotation.PathVariable;

public interface IUserController {
    com.uncub.dto.User getUserInfo(@PathVariable("name") String name);
}
