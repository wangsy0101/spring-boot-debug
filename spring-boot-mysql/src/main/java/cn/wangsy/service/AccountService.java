package cn.wangsy.service;

import cn.wangsy.dao.AccountMapper;
import cn.wangsy.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangsy on 2021/5/19
 */
@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;


    public Account queryOne(Long id){
        Account account = accountMapper.queryOne(id);
        // convert pojo
        return account;
    }

    public List<Account> queryByName(String name){
        List<Account> accountList = accountMapper.queryByName(name);
        // convert pojo
        return accountList;
    }


}
