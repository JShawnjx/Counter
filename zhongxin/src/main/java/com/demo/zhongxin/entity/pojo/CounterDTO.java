package com.demo.zhongxin.entity.pojo;

import com.demo.zhongxin.entity.Counter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CounterDTO {

    /** Dto 拓展属性 */
    private String token;

    public void from(Counter counter){

    }
}
