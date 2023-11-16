package com.demo.zhongxin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author JShawn
 */
@Data
@TableName("account")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
    @TableId
    private String accountNumber;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 6位数字密码
     */
    private String password;

    /**
     * 身份证号码
     */
    private String identification;

    /**
     * 证件类型
     */
    private String identificationType;

    /**
     * 账户名称
     */
    private String accountName;

    /**
     * 账户余额
     */
    private BigDecimal amount;

    /**
     * 账户状态
     */
    private Integer status;

    /**
     * 创建人
     */
    private Integer createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAccountNumber() == null) ? 0 : getAccountNumber().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getIdentification() == null) ? 0 : getIdentification().hashCode());
        result = prime * result + ((getIdentificationType() == null) ? 0 : getIdentificationType().hashCode());
        result = prime * result + ((getAccountName() == null) ? 0 : getAccountName().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", accountNumber=").append(accountNumber);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", identification=").append(identification);
        sb.append(", identificationType=").append(identificationType);
        sb.append(", accountName=").append(accountName);
        sb.append(", amount=").append(amount);
        sb.append(", status=").append(status);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}

