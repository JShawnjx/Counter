package com.demo.zhongxin.handler;

import com.demo.zhongxin.entity.Counter;
import com.demo.zhongxin.entity.pojo.CounterDTO;

public class CounterThreadLocal {

    private static final ThreadLocal<CounterDTO> LOCAL = new ThreadLocal<>();

    public static void put(CounterDTO counterDTO){
        LOCAL.set(counterDTO);
    }
    public static CounterDTO get(){
        return LOCAL.get();
    }
    public static void remove(){
        LOCAL.remove();
    }
}
