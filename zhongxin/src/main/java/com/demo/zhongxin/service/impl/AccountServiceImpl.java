package com.demo.zhongxin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.zhongxin.entity.Account;
import com.demo.zhongxin.mapper.IAccountMapper;
import com.demo.zhongxin.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl extends ServiceImpl<IAccountMapper, Account> implements AccountService {

}
