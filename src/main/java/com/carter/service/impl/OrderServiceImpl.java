package com.carter.service.impl;

import com.carter.mapper.TheOrderMapper;
import com.carter.pojo.TheOrder;
import com.carter.pojo.TheOrderExample;
import com.carter.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private TheOrderMapper theOrderMapper;

    @Override
    public PageInfo<Map<String, Object>> getOrderListByParam(int page, int limit, String orderSn, String tabType, String startDate) {
        PageHelper.startPage(page,limit);

        List<Map<String, Object>> maps = theOrderMapper.selOrderList(orderSn, tabType, startDate);

        //分页代码
        //设置分页条件
        PageInfo<Map<String, Object>> pi = new PageInfo<Map<String, Object>>(maps);
        return pi;
    }
}
