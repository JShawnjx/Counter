package com.demo.zhongxin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.zhongxin.entity.Counter;

public interface ICounterMapper extends BaseMapper<Counter> {
     Counter findCounterByName(String name);
}
