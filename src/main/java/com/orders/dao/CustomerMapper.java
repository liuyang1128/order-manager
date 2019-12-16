package com.orders.dao;

import com.orders.pojo.po.Customer;
import com.orders.util.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper extends MyMapper<Customer> {
}