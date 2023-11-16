package com.demo.zhongxin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.zhongxin.common.R;
import com.demo.zhongxin.entity.Account;
import com.demo.zhongxin.entity.Counter;
import com.demo.zhongxin.entity.Transfer;

public interface CounterService extends IService<Counter> {

    public R login(String name, String password);
    public R logout();
    public R addaccount(Account account);
    public R deleteaccount(String account_number, String password);
    public R account_info(String account_number, String password);
    public R transfer(Transfer transfer);
}