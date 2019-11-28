package com.carter.controller;

import com.carter.common.ResponseBo;
import com.carter.mapper.TheOrderMapper;
import com.carter.pojo.TheOrder;
import com.carter.pojo.TheOrderExample;
import com.carter.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderServiceImpl;

    @Resource
    private TheOrderMapper orderMapper;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public ResponseBo test(int page, int limit,@RequestParam Map<String,Object> map){
        String tabType = (String)map.get("tabType");
        String dateRange = (String)map.get("dateRange");
        String orderSn = (String)map.get("orderSn");
        String startDate = "";

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置时间范围
        if (dateRange!=null&&!dateRange.equals("")){
            if (dateRange.equals("today")){
                c.set(Calendar.HOUR_OF_DAY, 0);
                c.set(Calendar.MINUTE, 0);
                c.set(Calendar.SECOND, 0);
                startDate = sdf.format(c.getTime());
            }else if (dateRange.equals("week")){
                c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)-7);
                startDate = sdf.format(c.getTime());
            }else if (dateRange.equals("month")){
                c.set(Calendar.MONTH, c.get(Calendar.MONTH)-1);
                startDate = sdf.format(c.getTime());
            }
        }

        PageInfo<Map<String, Object>> pi = orderServiceImpl.getOrderListByParam(page, limit, orderSn, tabType, startDate);
        return ResponseBo.list(200,"ok",pi.getTotal(),pi.getList());
    }

    @RequestMapping(value = "test2",method = RequestMethod.GET)
    public ResponseBo test2(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)-7);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(c.getTime()));
        return ResponseBo.success(200,"ok",orderMapper.selOrderList("","",sdf.format(c.getTime())));
    }
}
