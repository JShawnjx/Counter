package com.demo.zhongxin.common;

import java.io.Serializable;

public interface IResultCode extends Serializable {
    String getMessage();

    int getCode();
}

