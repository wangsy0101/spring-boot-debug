package cn.wangsy.controller;

import cn.wangsy.common.RespObject;
import cn.wangsy.entity.Account;
import cn.wangsy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangsy on 2021/5/19
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/v1/account/id/{id}", method = RequestMethod.GET)
    public RespObject queryOne(@PathVariable("id") Long id) {
        Account account = accountService.queryOne(id);
        return RespObject.ok("result", account);
    }



    @RequestMapping(value = "/v1/account/name/{name}", method = RequestMethod.GET)
    public RespObject queryOne(@PathVariable("name") String name) {
        List<Account> accountList = accountService.queryByName(name);
        return RespObject.ok("result", accountList);
    }


}