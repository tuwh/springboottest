package com.uncub.controller;


import com.uncub.common.dao.Pagination;
import com.uncub.condition.UserConditions;
import com.uncub.dao.UserMapper;
import com.uncub.dto.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController implements IUserController{
    @Autowired
    UserMapper userMapper;
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    @RequestMapping("/{name}")
    public User getUserInfo(@PathVariable("name") String userNo){
        User userDto = new User();
        userDto.setUserNo(userNo);
//        PageHelper.startPage(2,1);
        Pagination<User> userPagination = new Pagination<User>();
//        User user=  userMapper.queryUser(userDto, userPagination).get(0);
//        User user = userMapper.selectUserById(2);
//        user.setUserName("李四1");
//        userMapper.updateUserById(user);
        UserConditions userConditions = new UserConditions();
        userConditions.createCriteria().andIdEqualTo(1).andUserNameLike("李四%");
        Pagination pagination = new Pagination(1, 5);
        userMapper.queryUserByConditions(userConditions, pagination);
        return null;
    }

    @RequestMapping("/userid/{id}")
    public User getUserInfoById(@PathVariable("id") Integer id){
        User user=  userMapper.selectUserById(id);
        return user;
    }


}
