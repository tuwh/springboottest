/*
package com.uncub.mysql;

import com.uncub.controller.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.caucho.HessianExporter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userinfo")
public class UserViewController {
    @Autowired
    UserDtoMapper userDtoMapper;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/{userNo}")
    public UserDto getUserInfo(@PathVariable("userNo") String userNo){
//        return userDAO.getUserByUserNo(userNo);
//        return userDAO.selectUserByUserNo(userNo);
        return userDtoMapper.selectUserByUserNo1(userNo);
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestParam("userNo") String userNo, @RequestParam("userName") String userName){
        UserDto userDto = new UserDto();
        userDto.setUserNo(userNo);
        userDto.setUserName(userName);
        userDAO.addUser(userDto);
        System.out.println(userDto.getId());
        return "Success";
    }

}
*/
