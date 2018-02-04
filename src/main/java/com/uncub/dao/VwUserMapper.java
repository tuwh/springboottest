package com.uncub.dao;

import com.uncub.common.dao.Pagination;
import com.uncub.condition.VwUserConditions;
import com.uncub.dto.VwUser;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface VwUserMapper {
    /**
    * 根据查询条件进行查找
    * @Param vwUser
    * @auth tuwh
    */
    List<VwUser> queryVwUserByConditions(VwUserConditions vwUserConditions);

    /**
    * 根据所有不为空条件进行查询，分页。结果将传入@Param pagination 参数中
    */
    List<VwUser> queryVwUser(VwUser vwUser, Pagination pagination);

    /**
    * 根据所有不为空条件进行查询，不分页
    */
    List<VwUser> queryVwUser(VwUser vwUser);

    /**
    * 根据所有不为空条件进行查询，分页。结果将传入@Param pagination 参数中
    */
    List<VwUser> queryVwUserByConditions(VwUserConditions vwUserConditions, Pagination pagination);
}