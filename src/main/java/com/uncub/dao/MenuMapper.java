package com.uncub.dao;

import com.uncub.common.dao.Pagination;
import com.uncub.condition.MenuConditions;
import com.uncub.dto.Menu;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface MenuMapper {
    /**
    * 根据主键进行删除
    * @Param id
    * @auth tuwh
    */
    int deleteMenuById(Integer id);

    /**
    * 根据主键进行新增,插入所有字段
    * @Param menu
    */
    int inset(Menu menu);

    /**
    * 根据主键进行新增,插入非空字段
    * @Param menu
    */
    int insetSelective(Menu menu);

    /**
    * 根据查询条件进行查找
    * @Param menu
    * @auth tuwh
    */
    List<Menu> queryMenuByConditions(MenuConditions menuConditions);

    /**
    * 根据主键进行查找
    * @Param menu
    * @auth tuwh
    */
    Menu selectMenuById(Integer id);

    /**
    * 根据主键进行更新，仅更新非主空字段
    * @Param menu
    */
    int updateMenuByIdSelective(Menu menu);

    /**
    * 根据主键进行更新，更新所有字段
    * @Param menu
    */
    int updateMenuById(Menu menu);

    /**
    * 根据所有不为空条件进行查询，分页。结果将传入@Param pagination 参数中
    */
    List<Menu> queryMenu(Menu menu, Pagination pagination);

    /**
    * 根据所有不为空条件进行查询，不分页
    */
    List<Menu> queryMenu(Menu menu);

    /**
    * 根据所有不为空条件进行查询，分页。结果将传入@Param pagination 参数中
    */
    List<Menu> queryMenuByConditions(MenuConditions menuConditions, Pagination pagination);
}