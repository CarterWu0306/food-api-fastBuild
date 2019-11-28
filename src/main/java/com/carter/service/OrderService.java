package com.carter.service;

import com.github.pagehelper.PageInfo;

import java.util.Map;


public interface OrderService {
    PageInfo<Map<String, Object>> getOrderListByParam(int page, int limit, String orderSn, String tabType, String startDate);
}
