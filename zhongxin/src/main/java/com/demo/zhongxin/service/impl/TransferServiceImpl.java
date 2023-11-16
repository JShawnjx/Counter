package com.demo.zhongxin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.zhongxin.entity.Transfer;
import com.demo.zhongxin.mapper.ITransferMapper;
import com.demo.zhongxin.service.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransferServiceImpl extends ServiceImpl<ITransferMapper, Transfer> implements TransferService {
}
