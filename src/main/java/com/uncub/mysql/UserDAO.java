package com.uncub.mysql;

import com.uncub.controller.UserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO {
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;


    public UserDto getUserByUserNo(String userNo){
        return sqlSessionTemplate.selectOne("getUserByUserNo", userNo);
    }

    public void addUser(UserDto userDto){
        sqlSessionTemplate.insert("saveUser", userDto);
    }

    @Select("select * from t_user where user_no = #{userNo}")
    public UserDto selectUserByUserNo(String userNo){
        return sqlSessionTemplate.selectOne("getUserByUserNo", userNo);
    }


}

