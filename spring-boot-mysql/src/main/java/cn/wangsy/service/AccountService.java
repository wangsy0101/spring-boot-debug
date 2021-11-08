package cn.wangsy.service;

import cn.wangsy.dao.AccountMapper;
import cn.wangsy.entity.Account;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "hello")
    public Account queryOne(Long id){
        try {
            Thread.sleep(5000);
        } catch (Exception e){

        }
        return accountMapper.queryOne(id);
    }


    public Account hello(Long id){
        Account account = new Account();
        account.setId(-1L);
        return account;
    }


    public List<Account> queryByName(String name){
        List<Account> accountList = accountMapper.queryByName(name);
        // convert pojo
        return accountList;
    }
}
