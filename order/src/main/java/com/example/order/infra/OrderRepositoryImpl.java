package com.example.order.infra;

import com.alibaba.druid.sql.dialect.mysql.visitor.transform.OrderByResolve;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.order.domain.OrderRepository;
import com.example.order.infra.mapper.OrderMapper;
import com.example.order.infra.model.OrderModel;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl extends ServiceImpl<OrderMapper, OrderModel> implements OrderRepository {
}