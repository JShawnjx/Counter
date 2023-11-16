package com.demo.zhongxin.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author JShawn
 */
@Data
@TableName("transfer")
public class Transfer {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 收款户名
     */
    private Integer payeeName;

    /**
     * 收款账号
     */
    private String payeeAccount;

    /**
     * 付款户名
     */
    private String payerName;

    /**
     * 付款账号
     */
    private String payerAccount;

    /**
     * 转账金额
     */
    private BigDecimal amount;

    /**
     * 创建人
     */
    private Integer createdBy;

    /**
     * 创建时间/转账成功时间
     */
    private Date createdTime;


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPayeeName() == null) ? 0 : getPayeeName().hashCode());
        result = prime * result + ((getPayeeAccount() == null) ? 0 : getPayeeAccount().hashCode());
        result = prime * result + ((getPayerName() == null) ? 0 : getPayerName().hashCode());
        result = prime * result + ((getPayerAccount() == null) ? 0 : getPayerAccount().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", payeeName=").append(payeeName);
        sb.append(", payeeAccount=").append(payeeAccount);
        sb.append(", payerName=").append(payerName);
        sb.append(", payerAccount=").append(payerAccount);
        sb.append(", amount=").append(amount);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}
