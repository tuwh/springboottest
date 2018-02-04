package com.uncub.redis;

import com.uncub.controller.UserDto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Cacheable("accountCache")
    public UserDto getUserByName(String userNo) {
        System.out.println("=======================getUserByName" + userNo);
        UserDto userDto = new UserDto();
        userDto.setUserNo(userNo);
        userDto.setUserName("userName");
        return userDto;
    }

    @CachePut(value = "accountCache", key="#userNo")
    public UserDto updateUser(String userNo){
//        throw new RuntimeException();
        System.out.println("===================updateUser" + userNo);
        UserDto userDto = new UserDto();
        userDto.setUserNo(userNo);
        userDto.setUserName("update user name");
        return userDto;
    }

    @CacheEvict(value = "accountCache", beforeInvocation = true)
    public String deleteUser(String userNo){
        System.out.println("===================updateUser" + userNo);
        return "success";
    }
}
