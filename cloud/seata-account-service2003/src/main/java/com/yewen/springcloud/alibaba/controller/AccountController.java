package com.yewen.springcloud.alibaba.controller;

import com.yewen.springcloud.alibaba.domain.Account;
import com.yewen.springcloud.alibaba.service.AccountService;
import com.yewen.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author ShadowStart
 * @create 2021-07-14 21:37
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping(value = "/account/decrease")
    public CommonResult<Account> decreaseAccount(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult<>(200, "扣减账户余额成功");
    }
}
