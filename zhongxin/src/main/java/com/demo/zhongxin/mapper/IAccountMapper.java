package com.demo.zhongxin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.zhongxin.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAccountMapper extends BaseMapper<Account> {
}
