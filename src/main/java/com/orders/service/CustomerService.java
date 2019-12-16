package com.orders.service;

import com.orders.common.PageModel;
import com.orders.pojo.dto.CustomerConditionDto;
import com.orders.pojo.dto.CustomerDto;
import com.orders.pojo.po.Customer;

/**
 * Author: zc
 * Date: 2018/5/4
 * Description:
 */
public interface CustomerService {
    PageModel<Customer> getCustomerList(CustomerConditionDto customerConditionDto,PageModel pageModel);

    Customer getCustomerById(Long customerId);

    void updateCustomer(Long customerId, CustomerDto customerDto);

    void deleteCustomerById(Long customerId);

    void addCustomer(CustomerDto customerDto);
}
