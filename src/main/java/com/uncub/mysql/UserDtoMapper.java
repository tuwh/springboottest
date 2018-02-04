package com.uncub.mysql;

import com.uncub.controller.UserDto;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.Cacheable;

@MapperScan
public interface UserDtoMapper {
    @Select("select * from t_user where user_no = #{userNo}")
    @ResultMap("userMapEntity")
    @Cacheable(value = "userinfo")
    UserDto selectUserByUserNo1(String userNo);
}
