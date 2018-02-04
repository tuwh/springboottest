package com.uncub.redis;

import com.uncub.controller.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/redis")
@RestController
public class RedisController {
    @Autowired
    RedisService redisService;

    @RequestMapping("/viewUser/{userName}")
    public UserDto viewUser(@PathVariable("userName") String userName) {
        return redisService.getUserByName(userName);
    }

    @RequestMapping("/update/{userName}")
    public UserDto updateUser(@PathVariable("userName") String userName) {
        return redisService.updateUser(userName);
    }

    @RequestMapping("/delete/{userName}")
    public String deleteUser(@PathVariable("userName") String userName) {
        return redisService.deleteUser(userName);
    }


}
