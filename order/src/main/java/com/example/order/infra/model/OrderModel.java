package com.example.order.infra.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("order")
@Data
public class OrderModel {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String orderId;
    private Long goodsId;
    private String remarks;
    private Date updateTime;
    private Long updateUser;
    private Date createTime;
    private Long createUser;
}
