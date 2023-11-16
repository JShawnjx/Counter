package com.demo.zhongxin.handler;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.demo.zhongxin.common.RedisKey;
import com.demo.zhongxin.entity.Counter;
import com.demo.zhongxin.entity.pojo.CounterDTO;
import com.demo.zhongxin.service.CounterService;
import com.demo.zhongxin.common.R;
import com.demo.zhongxin.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception{

        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod)object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            if(passToken.required()){
                return true;
            }
        }
        String token = httpServletRequest.getHeader("Authorization");
        token = token.replace("Bearer","");
        //检查有没有需要用户权限的注解
        if(method.isAnnotationPresent(CounterLoginToken.class)){
            CounterLoginToken counterLoginToken = method.getAnnotation(CounterLoginToken.class);
            if(counterLoginToken.required()){
                //执行认证
                if(token == null){
                    throw new RuntimeException("无token,请重新登录");
                }
                //获取token中的counter id
                String counterId;
                try{
                    boolean verify= JWTUtils.verify(token);
                    if (!verify){
                        httpServletResponse.setContentType(("application/json;charset=utf-8"));
                        httpServletResponse.getWriter().write(JSON.toJSONString(R.fail("未登录")));
                        return false;
                    }
                    String userJson = stringRedisTemplate.opsForValue().get(RedisKey.TOKEN+token);
                    if(StringUtils.isBlank(userJson)){
                        httpServletResponse.setContentType(("application/json;charset=utf-8"));
                        httpServletResponse.getWriter().write(JSON.toJSONString(R.fail("未登录")));
                        return false;
                    }
                } catch (Exception e){
                    throw new Exception("401");
                }
                String userJson = stringRedisTemplate.opsForValue().get(RedisKey.TOKEN+token);
                CounterDTO counterDTO = JSON.parseObject(userJson, CounterDTO.class);
                CounterThreadLocal.put(counterDTO);
                return true;
            }
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object object,Exception e)throws Exception{
        //如果不删除 ThreadLocal中用完的信息 会有内存泄漏的风险
        CounterThreadLocal.remove();
    }
}
