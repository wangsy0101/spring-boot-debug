package cn.wangsy.dao;

import cn.wangsy.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangsy on 2021/5/19
 */
public interface AccountMapper {


    Account queryOne(@Param("id") Long id);

    List<Account> queryByName(@Param("name") String name);
}
