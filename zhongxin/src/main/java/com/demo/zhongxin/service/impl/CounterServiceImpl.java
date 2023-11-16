package com.demo.zhongxin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.zhongxin.common.R;
import com.demo.zhongxin.common.RedisKey;
import com.demo.zhongxin.entity.Account;
import com.demo.zhongxin.entity.Counter;
import com.demo.zhongxin.entity.Transfer;
import com.demo.zhongxin.entity.pojo.CounterDTO;
import com.demo.zhongxin.mapper.ICounterMapper;
import com.demo.zhongxin.service.AccountService;
import com.demo.zhongxin.service.CounterService;
import com.demo.zhongxin.service.TransferService;
import com.demo.zhongxin.utils.JWTUtils;
import com.demo.zhongxin.utils.MD5Utils;
import lombok.AllArgsConstructor;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class CounterServiceImpl extends ServiceImpl<ICounterMapper, Counter> implements CounterService {

//    @Resource
//    private StringRedisTemplate redisTemplate;
    @Autowired
    private final AccountService accountService;
    @Autowired
    private final TransferService transferSerivce;

    @Override
    public R login(String name, String password){
        try {
            Counter counter = baseMapper.findCounterByName(name);
            System.out.println("密码："+MD5Utils.inputPassToFormPass(password));
            if(MD5Utils.inputPassToFormPass(password).equals(counter.getPassword())){
                String token = JWTUtils.sign(Long.valueOf(counter.getId()));
                CounterDTO counterDTO = new CounterDTO();
                counterDTO.setToken(token);
//                redisTemplate.opsForValue().set(RedisKey.TOKEN+token, JSON.toJSONString(counterDTO),7, TimeUnit.HOURS);
                return R.data(counterDTO);
            }
            return R.fail("账户名或密码错误");
        }catch (Exception e){
            e.printStackTrace();
            return R.fail("账户名或密码错误");
        }
    }

    @Override
    public R logout(){
        return R.success("成功");
    }

    @Override
    public R addaccount(Account account){
        return R.success("成功");
    }

    @Override
    public R deleteaccount(String account_number, String password){
        return R.success("成功");
    }

    @Override
    public R account_info(String account_number, String password){
        return R.success("成功");
    }

    @Override
    public R transfer(Transfer transfer){
        return R.success("成功");
    }


}
