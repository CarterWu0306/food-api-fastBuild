package com.carter.service.impl;

import com.carter.common.ResponseBo;
import com.carter.mapper.GoodsMapper;
import com.carter.pojo.Goods;
import com.carter.pojo.GoodsExample;
import com.carter.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation= Propagation.REQUIRED)
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public int addGoods(Goods goods) {
        int index = goodsMapper.insertSelective(goods);
        return index;
    }

    @Override
    public int updateGoods(Goods goods) {
        int index = goodsMapper.updateByPrimaryKey(goods);
        return index;
    }

    @Override
    public int changeGoodsStatus(Goods goods) {
        int index = goodsMapper.updateByPrimaryKeySelective(goods);
        return index;
    }

    @Override
    public int deleteGoods(int goodsId) {
        int index = goodsMapper.deleteByPrimaryKey(goodsId);
        return index;
    }

    @Override
    public ResponseBo selGoodsListByParam(int page, int limit, Map<String, Object> map) {
        PageHelper.startPage(page,limit);

        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();

        String goodsName = (String)map.get("goodsName");
        String goodsLabel = (String)map.get("goodsLabel");
        String goodsStatus = (String)map.get("goodsStatus");

        //设置查询条件
        if (goodsName!=null && !goodsName.equals("")){
            criteria.andGoodsNameEqualTo(goodsName);
        }
        if (goodsLabel!=null && !goodsLabel.equals("")){
            criteria.andGoodsLabelEqualTo(goodsLabel);
        }
        if (goodsStatus!=null && !goodsStatus.equals("")){
            criteria.andGoodsStatusEqualTo(goodsStatus);
        }

        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);

        //分页代码
        //设置分页条件
        PageInfo<Goods> pi = new PageInfo<>(goodsList);

        return ResponseBo.list(200,"查询商品列表成功",pi.getTotal(),pi.getList());
    }
}
